package src.lighting;

import src.main.java.entity.NodeStatusConstant;
import src.main.java.util.EmptyUtils;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther : wangyufei
 * @date : 2020-10-25
 **/
public class Graph {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private List<Node> nodes;

    private CountDownLatch countDownLatch;

    private WorkContext context;

    public Lock getLock() {
        return lock;
    }

    public Condition getCondition() {
        return condition;
    }

    public Graph() {
        nodes = new CopyOnWriteArrayList<>();
    }

    /**
     * 添加节点
     */
    public void addNode(Node node) {
        if (null != node) {
            nodes.add(node);
        }
    }

    /**
     * 默认关系类型，前置节点执行成功后执行后置节点
     */
    public void addEdge(Node preNode, Node postNode) {
        if (null == preNode || null == postNode || preNode == postNode) {
            return;
        }
        preNode.addPostNode(postNode, Relation.INVOKE_SUCCESS);
        postNode.addPreNode(preNode, Relation.INVOKE_SUCCESS);
    }


    /**
     * 自定义节点间关系类型
     */
    public void addEdge(Node preNode, Node postNode, Relation relation) {
        if (null == preNode || null == postNode || preNode == postNode) {
            return;
        }
        preNode.addPostNode(postNode, relation);
        postNode.addPreNode(preNode, relation);
    }

    public Node getByName(String name) {
        if (!EmptyUtils.isEmpty(name)) {
            for (Node node : nodes) {
                if (name.equals(node.getName())) {
                    return node;
                }
            }
        }
        return null;
    }

    /**
     * 标记节点成功
     */
    public boolean markNodeFinished(Node node) {
        return markNodeStatus(node, NodeStatusConstant.FINISHED);

    }

    /**
     * 标记节点在执行中
     */
    public boolean markNodeProcessing(Node node) {
        return markNodeStatus(node, NodeStatusConstant.PROCESSING);
    }

    /**
     * 标记节点执行失败
     */
    public boolean markNodeFailure(Node node) {
        return markNodeStatus(node, NodeStatusConstant.FAILURE);
    }

    /**
     * 标记节点的状态，如果标记成功返回true，标记不成功返回false
     * 该操作需要保证原子性
     */
    private boolean markNodeStatus(Node node, int nodeStatus) {
        boolean flag = node.markStatus(nodeStatus);
        if (flag && (nodeStatus == NodeStatusConstant.FINISHED || nodeStatus == NodeStatusConstant.FAILURE)) {
            countDownLatch.countDown();
            //打点
            if (countDownLatch.getCount() == 0) {
                lock.lock();
                try {
                    condition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
        return flag;
    }


}

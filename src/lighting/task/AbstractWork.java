package src.lighting.task;

import src.main.java.Graph;
import src.main.java.Node;
import src.main.java.WorkContext;

/**
 * @auther : Duffy
 * @date : 2020-10-25
 **/
public abstract class AbstractWork<T> implements Work<T> {
    /**
     * Request Context including
     */
    private WorkContext workContext;

    /**
     * Alias
     */
    private String alias;

    /**
     * weight decides priority
     */
    private int weight;

    /**
     * Default timeout time, prevent long time waiting
     */
    private int timeout = 1000;

    private String workName = getClass().getSimpleName();


    //---------Override Work interface method-------------------------

    /**
     * 如果有别名，返回别名
     * 返回任务名
     */
    @Override
    public String getWorkName() {
        if (alias != null && alias.length() != 0) {
            return alias;
        }
        if (workName != null && workName.length() != 0) {
            return workName;
        }
        return this.getClass().getSimpleName();
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean callback(Object result) throws InterruptedException {
        return true;
    }

    @Override
    public void failed(Throwable e) {

    }

    @Override
    public boolean match() {
        return true;
    }

    @Override
    public String getRatelimiterKey() {
        return null;
    }

    //------------AbstractWork method----------------

    public abstract void sendRequest();


    /**
     * 标记节点成功
     */
    protected boolean markFinished() {
        Graph graph = getWorkContext().getGraph();
        Node node = graph.getByName(getWorkName());
        return graph.markNodeFinished(node);
    }

    /**
     * 标记节点在处理中
     */
    protected boolean markProcessing() {
        Graph graph = getWorkContext().getGraph();
        Node node = graph.getByName(getWorkName());
        return graph.markNodeProcessing(node);
    }

    /**
     * 标记节点执行失败
     */
    protected boolean markFailure() {
        Graph graph = getWorkContext().getGraph();
        Node node = graph.getByName(getWorkName());
        return graph.markNodeFailure(node);
    }


    /**
     * execute or not
     * 1.business logic eg: version time,etc.
     * 2.forbidden list
     */
    public boolean shouldDo() {
        return match() && !getWorkContext().getForbiddenWorks().contains(getClass().getName());
    }


    //------------Getter and Setter------------------

    public WorkContext getWorkContext() {
        return workContext;
    }

    public void setWorkContext(WorkContext workContext) {
        this.workContext = workContext;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }
}

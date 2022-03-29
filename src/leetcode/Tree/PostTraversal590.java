package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2022-03-12
 * <p>
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔
 **/
public class PostTraversal590 {
    public List<Integer> res = new ArrayList<Integer>();

    public List<Integer> postorder(Node root) {
        postTraversal(root);
        return res;
    }

    public void postTraversal(Node node) {
        if (node == null) return;
        int n = node.children.size();
        for (int i = 0; i < n; i++) {
            //这个顺序不变，前中后变得顺序是res.add(node.val);
            postTraversal(node.children.get(i));
        }
        res.add(node.val);

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}

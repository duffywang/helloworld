package leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-09-20
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 **/
public class MaxDepth559 {
    public static int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.size() == 0) return 1;

        List<Node> children = root.children;
        ArrayList<Integer> list = new ArrayList<>(children.size());
        for (int i = 0; i < children.size(); i++) {
            list.add(maxDepth(children.get(i)) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < children.size(); i++) {
            if (list.get(i) > max) max = list.get(i);
        }
        return max;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.children = new ArrayList<>();
        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);
        node2.children = new ArrayList<>();
        node2.children.add(node5);
        node2.children.add(node6);
        int res = maxDepth(node1);
        System.out.println(res);
    }
}

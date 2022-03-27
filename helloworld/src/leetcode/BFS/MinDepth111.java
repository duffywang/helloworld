package leetcode.BFS;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther : wangyufei
 * @date : 2021-06-19
 **/
public class MinDepth111 {

    class NodeDep {
        TreeNode node;
        int depth;

        public NodeDep(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null)return 0;
        Queue<NodeDep> queue = new LinkedList<>();
        queue.offer(new NodeDep(root, 1));

        while (!queue.isEmpty()) {
            NodeDep pollNode = queue.poll();
            if (pollNode.node.left == null && pollNode.node.right == null) return pollNode.depth;
            if (pollNode.node.left != null) queue.offer(new NodeDep(pollNode.node.left, pollNode.depth + 1));
            if (pollNode.node.right != null) queue.offer(new NodeDep(pollNode.node.right, pollNode.depth + 1));
        }
        return 0;
    }
}

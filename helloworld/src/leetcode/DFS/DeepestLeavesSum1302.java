package leetcode.DFS;

import leetcode.TreeNode;

/**
 * @auther : wangyufei
 * @date : 2020-09-20
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 **/
public class DeepestLeavesSum1302 {
    public static int total = 0;
    public static int maxDep = -1;

    public static int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return total;
    }

    private static void dfs(TreeNode root, int dep) {
        if (root == null) return;
        /**
         * 1、有比之前更深层
         * 2、就在当前认为最深层
         * 3、有更深层对当前层不处理
         * */
        if (dep > maxDep) {
            maxDep = dep;
            total = root.val;
        } else if (dep == maxDep) {
            total += root.val;
        }
        dfs(root.left, dep + 1);
        dfs(root.right, dep + 1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        int res = deepestLeavesSum(node1);
        System.out.println(res);

    }


}

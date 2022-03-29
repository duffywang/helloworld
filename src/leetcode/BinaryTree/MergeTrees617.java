package leetcode.BinaryTree;

import leetcode.TreeNode;

/**
 * @auther : wangyufei
 * @date : 2021-07-18
 **/
public class MergeTrees617 {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode merge = new TreeNode(root1.val + root2.val);
        merge.left = mergeTrees(root1.left, root2.left);
        merge.right = mergeTrees(root1.right, root2.right);
        return merge;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(2);
        TreeNode node14 = new TreeNode(5);

        node1.left = node12;
        node1.right = node13;
        node12.left = node14;

        TreeNode node2 = new TreeNode(2);
        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(3);
        TreeNode node23 = new TreeNode(4);
        TreeNode node24 = new TreeNode(7);

        node2.left = node21;
        node2.right = node22;
        node21.right = node23;
        node22.right = node24;

        TreeNode res = mergeTrees(node1, node2);

    }
}

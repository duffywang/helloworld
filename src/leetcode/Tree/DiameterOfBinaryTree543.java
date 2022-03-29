package leetcode.Tree;

import leetcode.TreeNode;

/**
 * @auther : wangyufei
 * @date : 2022-02-12
 * <p>
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：3
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 **/
public class DiameterOfBinaryTree543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        helper(root);
        return max;
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;

        int left = node.left != null ? helper(node.left) + 1 : 0;
        int right = node.right != null ? helper(node.right) + 1 : 0;

        max = Math.max(left + right, max);
        return Math.max(left, right);
    }
}

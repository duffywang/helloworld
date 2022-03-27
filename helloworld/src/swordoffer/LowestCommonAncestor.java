package swordoffer;

import leetcode.TreeNode;

/**
 * @auther : wangyufei
 * @date : 2020-08-20
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * <p>
 * 如果当前结点t 大于结点p、q，说明p、q都在t 的左侧，所以它们的共同祖先必定在t 的左子树中，故从t 的左子树中继续查找；
 * 如果当前结点t 小于结点p、q，说明p、q都在t 的右侧，所以它们的共同祖先必定在t 的右子树中，故从t 的右子树中继续查找；
 * 如果当前结点t 满足 p <t < q，说明p和q分居在t 的两侧，故当前结点t 即为最近公共祖先；
 * 而如果p是q的祖先，那么返回q的父结点，同理，如果q是p的祖先，那么返回p的父结点。
 * <p>
 * -------------------------------------------------------------------------------------------------
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 **/
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return root;
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor1(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}

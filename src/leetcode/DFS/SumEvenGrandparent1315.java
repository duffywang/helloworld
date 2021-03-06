package leetcode.DFS;

import leetcode.TreeNode;

/**
 * @auther : wangyufei
 * @date : 2020-09-20
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * <p>
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SumEvenGrandparent1315 {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) res += root.left.left.val;
                if (root.left.right != null) res += root.left.right.val;

            }
            if (root.right != null) {
                if (root.right.left != null) res += root.right.left.val;
                if (root.right.right != null) res += root.right.right.val;
            }
        }
        return res + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}

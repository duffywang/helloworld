package leetcode.BinaryTree;

import leetcode.TreeNode;

/**
 * @auther : wangyufei
 * @date : 2020-07-12
 * <p>
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 考察：深度优先查找，找每个节点的最大贡献值
 * 时间复杂度：
 * 空间复杂度：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxPathSum124 {
    private static int res = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }

    private static int getMax(TreeNode root) {
        if (root == null) return 0;
        //计算左边分支最大值，左边分支如果为负数还不如不选择
        int left = Math.max(0, getMax(root.left));
        //计算右边分支最大值，右边分支如果为负数还不如不选择
        int right = Math.max(0, getMax(root.right));
        //节点的最大路径和取决于该节点的值与该节点左右子节点的最大贡献值，与之前的作比较然后更新
        res = Math.max(res, root.val + left + right);
        //只能选一条路，要么是左子树+根，要么右子树+根
        return Math.max(left, right) + root.val;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node.left = node2;
        node.right = node3;
        int res = maxPathSum(node);
        System.out.println(res);

    }
}

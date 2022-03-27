package leetcode.DFS;

import leetcode.TreeNode;

/**
 * @auther : wangyufei
 * @date : 2020-09-20
 * <p>
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 *  /        / \
 * 1        7   9
 * <p>
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class IncreasingBST897 {
    TreeNode head = new TreeNode(0);
    TreeNode real = head;

    public TreeNode increasingBST(TreeNode root) {
        /*中止条件*/
        if (root == null) return null;
        /*中序遍历框架*/
        increasingBST(root.left);
        real.right = new TreeNode(root.val);
        real = real.right;
        increasingBST(root.right);
        /*虚头节点*/
        return head.right;
    }
}

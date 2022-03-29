package leetcode.DFS;

import leetcode.TreeNode;

/**
 * @auther : wangyufei
 * @date : 2020-09-20
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，一般都有多种结果它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3  9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SortedArrayToBST108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    /**
     * 时间复杂度为O(N) 每个数字只访问一次
     * 空间复杂度为O(log N)取决于栈的深度
     */
    private static TreeNode dfs(int[] nums, int s, int e) {
        if (s > e) return null;

        int mid = (e + s) / 2;
        //mid = (e + s + 1) / 2 总是选择中间右侧节点

        //分治，自底向上先构建叶子节点
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, s, mid - 1);
        root.right = dfs(nums, mid + 1, e);

        return root;

    }

    public static void main(String[] args) {
        int[] array = {-10, -3, 0, 5, 9};
        TreeNode res = sortedArrayToBST(array);

    }
}

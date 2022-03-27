package swordoffer;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-08-16
 * <p>
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 给定如下二叉树，以及目标和 sum = 22
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7   2   5   1
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class PathSum34 {
    private static List<List<Integer>> res;

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        backtrack(root, sum, new ArrayList<>());
        return res;
    }

    private static void backtrack(TreeNode root, int sum, List<Integer> list) {
        //不成功
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        //满足条件条件为：sum = 0;到叶子节点
        //不满足条件时：左子节点和右子节点，节点为空就回溯
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            backtrack(root.left, sum, list);
            backtrack(root.right, sum, list);
        }
        list.remove(list.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;
        List<List<Integer>> lists = pathSum(node1, 22);



    }
}

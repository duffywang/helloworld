package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2022-01-13
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * <p>
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 **/
public class KthSmallest230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, k);
        return res.get(k);

    }

    private void helper(TreeNode node, List<Integer> res, int k) {
        if (node == null) return;

        helper(node.left, res, k);
        if (res.size() == k) return;
        res.add(node.val);
        helper(node.right, res, k);

    }
}

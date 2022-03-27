package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-09-06
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 输入：
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 输出：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 **/
public class Flatten114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            //左子树都是空
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}

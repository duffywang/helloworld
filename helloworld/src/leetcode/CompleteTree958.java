package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther : wangyufei
 * @date : 2020-07-12
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
 * 第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 * [1,2,3,5,null,7,8] 预期为false
 * [1,2,3,4,5,6]预期为true
 **/
public class CompleteTree958 {
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //需要一个标志来判断中间子树是否null
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                flag = true;
                continue;
            }
            //可能没机会执行，因为不为空了
            if (flag) {
                return false;
            }
            queue.offer(node.left);
            queue.offer(node.right);

        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        boolean res = isCompleteTree(node1);
        System.out.println(res);

    }
}

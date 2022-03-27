package swordoffer;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther : wangyufei
 * @date : 2020-07-19
 * 只用输出一个int[] ,如果需要输出一个List<List<Integer>> ，while里嵌套for循环，循环界限为queue.size()
 **/
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int re : list) {
            res[i++] = re;
        }
        return res;
    }
}

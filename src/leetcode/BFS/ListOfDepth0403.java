package leetcode.BFS;

import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @auther : wangyufei
 * @date : 2021-06-19
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组。
 * 输入：[1,2,3,4,5,null,7,8]
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * <p>
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ListOfDepth0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        List<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(-1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode cur = dummy;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
            res.add(dummy.next);
        }
        ListNode[] listNode = new ListNode[res.size()];
        for (int i = 0; i < res.size(); i++) {
            listNode[i] = res.get(i);
        }
        return listNode;
    }
}

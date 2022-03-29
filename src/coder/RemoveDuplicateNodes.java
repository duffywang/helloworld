package coder;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @auther : wangyufei
 * @date : 2020-09-05
 * <p>
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 **/
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next != null) {
                if (pre.next.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            pre = pre.next;
        }
        return dummy.next;
    }

    public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            if (!set.contains(pre.next.val)) {
                set.add(pre.next.val);
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }
        return dummy.next;
    }
}

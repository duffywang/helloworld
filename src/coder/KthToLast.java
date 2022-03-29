package coder;

import leetcode.ListNode;

/**
 * @auther : wangyufei
 * @date : 2020-08-24
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * 使用提前走双指针完成
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 **/
public class KthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            head = head.next;
        }
        return head.val;
    }
}

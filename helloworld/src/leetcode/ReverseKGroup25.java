package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-07-12
 * 给你这个链表：1->2->3->4->5
 * 准备反转：pre - start - end - next
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 **/
public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;//断开与next的连接
            pre.next = reverse(start);
            start.next = next;//连接与next的连接
            pre = start; //重新配置pre与end ,start会在下一个循环中分配
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode cur = start;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

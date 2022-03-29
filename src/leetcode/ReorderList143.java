package leetcode;


/**
 * @auther : wangyufei
 * @date : 2020-07-12
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 **/
public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverse(newHead);

        //1(head) -> 2(head.next) -> 3
        //6(newHead) -> 5(next) -> 4
        //6 -> 2(newHead.next)  1 -> 6
        while (newHead != null) {
            ListNode next = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = next;
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

package leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点
 * input:1->2->6->3->4->5->6, val = 6
 * output:1->2->3->4->5
 *
 * @auther : wangyufei
 * @date : 2020-02-09
 **/
public class RemoveLinkedListElement203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

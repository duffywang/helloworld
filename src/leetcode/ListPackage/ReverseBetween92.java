package leetcode.ListPackage;

import leetcode.ListNode;

/**
 * @auther : wangyufei
 * @date : 2020-10-08
 **/
public class ReverseBetween92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = m; i < n; i++) {
            ListNode nex = head.next;
            head.next = nex.next;//2后面为4
            nex.next = pre.next;//3后面是2
            pre.next = nex;//1后面是3
        }
        return dummy.next;
    }

//    public ListNode reverseBetween2(ListNode head, int m, int n) {
//
//    }

    /**
     * 递归实现反转链表
     */
    public static ListNode reverseBase(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverseBase(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode res = reverseBase(node1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}

package leetcode.ListPackage;

import leetcode.ListNode;

/**
 * @auther : wangyufei
 * @date : 2021-08-16
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 采用
 **/
public class SortList148 {
    public static ListNode sortList(ListNode head) {
        return head == null ? head : mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head) {

        if (head.next == null) return head;

        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //stackoverflow
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);
        return merge(l, r);
    }

    private static ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l != null && r != null) {
            if (l.val >= r.val) {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            } else {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        //返回dummy.next
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode res = sortList(node1);
    }
}

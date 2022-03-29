package leetcode.ListNodePackage;

import leetcode.ListNode;

import java.util.HashSet;

/**
 * @auther : wangyufei
 * @date : 2020-01-29
 **/
public class LinkedListCycle141 {
    public static void main(String[] args) {


    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (listNodes.contains(head)) {
                return true;
            } else {
                listNodes.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}

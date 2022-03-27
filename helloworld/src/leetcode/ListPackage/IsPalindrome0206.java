package leetcode.ListPackage;

import leetcode.ListNode;

/**
 * @auther : wangyufei
 * @date : 2020-10-13
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 * <p>
 * 输入： 1->2
 * 输出： false
 **/
public class IsPalindrome0206 {
    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode node) {
        if (node == null) return true;
        boolean res = traverse(node.next);
        res = res && (node.val == left.val);
        left = left.next;
        return res;
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = traverse2(slow);
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode traverse2(ListNode node) {
        ListNode pre = null, cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        IsPalindrome0206 obj = new IsPalindrome0206();
        boolean res = obj.isPalindrome2(node1);
        System.out.println(res);
    }
}

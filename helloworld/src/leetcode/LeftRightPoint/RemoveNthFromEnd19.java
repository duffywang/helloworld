package leetcode.LeftRightPoint;

import leetcode.ListNode;

/**
 * @auther : wangyufei
 * @date : 2021-07-15
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 用例1：
 * 输入：[1,2,3,4,5] 2
 * 输出：[1,2,3,5]
 * <p>
 * 用例2：
 * 输入：[1,2] 1
 * 输出：[1]
 * <p>
 * 用例3：
 * 输入：[1,2] 2
 * 输出：[2]
 * <p>
 * 用例4：
 * 输入：[1] 1
 * 输出：[]
 * <p>
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 **/

//TODO
public class RemoveNthFromEnd19 {
    public static ListNode removeNthFromEnd0(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;
        int count = 0;

        while (first != null && first.next != null) {
            first = first.next;
            count++;
        }
        count = count - n;
        while (count != 0) {
            second = second.next;
            count--;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    /**
     * 慢节点使用dummy , 快节点使用head
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 方法二更加直观一点，没有使用dummy节点
     * 但是要注意判断right != null ，用例3 和 用例4都是right == null的情况
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;
        while (n != 0) {
            right = right.next;
            n--;
        }
        if (right != null) {
            while (right.next != null) {
                left = left.next;
                right = right.next;
            }
            left.next = left.next.next;

        } else {
            return head.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode res = removeNthFromEnd0(node, 1);


    }
}

package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-07-12
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 **/
public class ReverseList206 {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;

    }

    /**
     *
     * O(N)时间复杂度需要对链表的每个节点进行反转操作
     * O(N)空间复杂度主要取决于递归调用的栈空间，最多为n层
     * */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //先到尾结点
        ListNode newHead = reverseList2(head.next);
        //1 -> 2 -> 3 -> 4 -> 5
        //1 -> 2 -> 3 -> 4 <- 5
        //1 -> 2 -> 3 <- 4 <- 5
        //1 -> 2 <- 3 <- 4 <- 5
        //1 <- 2 <- 3 <- 4 <- 5
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode res = reverseList2(node1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}

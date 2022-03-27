package leetcode.LeftRightPoint;

import leetcode.ListNode;

/**
 * @auther : wangyufei
 * @date : 2020-09-26
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 **/
public class Partition86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummynode1 = new ListNode(0);
        ListNode dummynode2 = new ListNode(0);
        ListNode node1 = dummynode1;
        ListNode node2 = dummynode2;
        while (head != null) {

            if (head.val < x) {
                //需前移 放在前移链中node1
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;

            } else {
                //维持不动 放在后移链中node2
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = dummynode2.next;
        return dummynode1.next;

    }
}

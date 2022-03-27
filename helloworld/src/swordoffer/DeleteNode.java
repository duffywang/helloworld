package swordoffer;

import leetcode.ListNode;

/**
 * @auther : wangyufei
 * @date : 2020-07-19
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            pre = head;
            head = head.next;
        }
        return head;
    }

    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        if (cur.val == val) return head.next;
        while (cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}

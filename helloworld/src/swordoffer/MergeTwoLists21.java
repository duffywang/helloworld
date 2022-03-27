package swordoffer;

import leetcode.ListNode;

/**
 * @auther : wangyufei
 * @date : 2020-07-19
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 四个选项，每个选项都要返回结果，终止条件在为null的时候
 **/
public class MergeTwoLists21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node11 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node44 = new ListNode(4);
        node1.next = node2;
        node2.next = node4;
        node11.next = node3;
        node3.next = node44;
        ListNode res = mergeTwoLists(node1, node11);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

}

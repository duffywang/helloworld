package leetcode;

import java.util.Date;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * input:1->2->3->3->3->4->4->5
 * output:1->2->5
 *
 * @auther : wangyufei
 * @date : 2020-02-09
 **/
public class RemoveDuplicateSortList82 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode node = deleteDuplicates(node1);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        //为了防止删除头结点的极端情况发生，先创建空结点dummy，使dummy指向传入的head结点。
        //然后创建cur的指针，指向链表的头部（即dummy）
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                //双指针，记录初始点
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                //实现了消除重复元素
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;

    }
}

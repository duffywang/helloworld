package swordoffer;

import leetcode.ListNode;

/**
 * @auther : wangyufei
 * @date : 2020-07-15
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 思路：不用反转链表，直接得到链表的节点数量，倒排用数组记录值
 **/
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        int[] array = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; i--) {
            array[i] = node.val;
            node = node.next;
        }
        return array;

    }

}

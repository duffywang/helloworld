package leetcode;

import java.util.HashMap;

/**
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 * input:[1,2,-3,3,1]
 * output:[3,1] [1,2,1]均可
 * [0,1,3,4]
 *
 *
 * sum:[0,1,3,6,3,1]
 * map:[0,1,3,6]
 * @auther : wangyufei
 * @date : 2020-02-03
 **/
public class RemoveNodesFromLinkedList1171 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(-3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode res = removeZeroSumSublists(listNode1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        //与head相连
        ListNode init = new ListNode(0);
        init.next = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode i = init; i != null; i = i.next) {
            sum += i.val;
            map.put(sum, i);
        }
        sum = 0;
        for (ListNode i = init; i != null; i = i.next) {
            sum += i.val;
            i.next = map.get(sum).next;
        }
        return init.next;

    }
}

package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-07-12
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 链表前面为低位，后面为高位，起始都是个位
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 **/
public class AddTwoNumbers2 {
    /*
     * 与leetcode 415类似，链表节点数据相加
     * 在while都需要
     * */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        int carrier = 0;
        //只要任l1、l2一位有值或进位有值
        while (carrier != 0 || l1 != null || l2 != null) {
            if (l1 != null) {
                carrier = carrier + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carrier = carrier + l2.val;
                l2 = l2.next;
            }
            res.next = new ListNode(carrier % 10);
            carrier = carrier / 10;
            //移位
            res = res.next;
        }
        //进位
//        if (carrier == 1)
//            res.next = new ListNode(1);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node5.next = node6;
        node6.next = node7;
        //4321 + 765 = 5086
        ListNode res = addTwoNumbers(node1, node5);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}

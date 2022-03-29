package leetcode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * input:1->1->2
 * output:1->2
 *
 * @auther : wangyufei
 * @date : 2020-02-09
 **/
public class RemoveDuplicateSortList83 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        listNode2 = listNode1.next;
        listNode3 = listNode2.next;
        listNode4 = listNode3.next;
        ListNode res = deleteDuplicates(listNode1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode init = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return init;
    }

    /**
     * 快慢双指针法
     **/
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.val != slow.val) {
                //直接跳跃
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;

    }
}

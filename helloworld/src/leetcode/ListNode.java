package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-01-29
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode node) {
        this.val = val;
        this.next = node;
    }
}

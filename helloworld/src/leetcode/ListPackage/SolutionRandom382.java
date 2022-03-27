package leetcode.ListPackage;

import leetcode.ListNode;

import java.util.Random;

/**
 * @auther : wangyufei
 * @date : 2020-10-11
 **/

class SolutionRandom382 {

    private ListNode head;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public SolutionRandom382(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int i = 0, res = 0;
        ListNode node = head;
        Random random = new Random();
        while (node != null) {
            //取[0,n)之间的整数，即保底是会取到1，最后还取1的概率 1/2 * 2/3 * 3/4 = 1/4每个节点的概率相同
            if (random.nextInt(++i) == 0) {
                res = node.val;
            }
            node = node.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SolutionRandom382 obj = new SolutionRandom382(node1);
        int random1 = obj.getRandom();
        int random2 = obj.getRandom();
        int random3 = obj.getRandom();
        int random4 = obj.getRandom();
        System.out.println("random1: " + random1);
        System.out.println("random2: " + random2);
        System.out.println("random3: " + random3);
        System.out.println("random4: " + random4);

    }
}
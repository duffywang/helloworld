package swordoffer;

import leetcode.ListNode;

/**
 * @auther : wangyufei
 * @date : 2020-08-15
 **/
public class GetIntersectionNode52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (headA != null) {
            headA = headA.next;
            countA++;
        }
        while (headB != null) {
            headB = headB.next;
            countB++;
        }
        if (countA > countB) {
            for (int i = 0; i < (countA - countB); i++) {
                tempA = tempA.next;
            }

        } else {
            for (int i = 0; i < (countB - countA); i++) {
                tempB = tempB.next;
            }
        }
        while (tempA != null && tempB != null) {
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;

    }

    // 设链路交集长度为c,headA非交集部分为a,headB非交集部分为b
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;

        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;

    }


}

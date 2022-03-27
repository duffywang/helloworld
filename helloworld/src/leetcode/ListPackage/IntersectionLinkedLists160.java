package leetcode.ListPackage;

import leetcode.ListNode;

/**
 * 找到两个单链表相交的起始节点
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther : wangyufei
 * @date : 2020-02-01
 **/
public class IntersectionLinkedLists160 {

    /**
     * 暴力解法
     * */
    public static ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        while (headA != null) {
            //注意内层循环每次要重新开始
            ListNode h2 = headB;
            while (h2 != null) {
                if (headA == h2) return headA;
                else {
                    h2 = h2.next;
                }
            }
            headA = headA.next;
        }
        return null;

    }


    /**
     * 快慢走，先遍历一遍先算是两条链表各自的长度
     * 从头再遍历一遍长的链表先走多的距离，然后两条链表同时走对比节点是否相同
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int len1 = 0, len2 = 0;
        ListNode copyA = headA;
        ListNode copyB = headB;
        while (copyA != null) {
            copyA = copyA.next;
            len1++;
        }
        while (copyB != null) {
            copyB = copyB.next;
            len2++;
        }
        if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                headB = headB.next;
            }
        } else {
            for (int i = 0; i < len1 - len2; i++) {
                headA = headA.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * headA（m+x）和headB(n+x) 头尾衔接，m+x+n = n+x+m 此时能找到两个单链表相交的起始节点
     * */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node5;

        ListNode node6 = new ListNode(3);
        node6.next = node3;
        node3.next = node5;

        ListNode intersectionNode2 = getIntersectionNode0(node, node6);
        System.out.println(intersectionNode2.val);

    }

}

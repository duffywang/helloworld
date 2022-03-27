package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-08-16
 **/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
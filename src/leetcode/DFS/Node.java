package leetcode.DFS;

import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-09-20
 **/
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
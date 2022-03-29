package leetcode.BFS;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther : wangyufei
 * @date : 2020-11-21
 * <p>
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * <p>
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class IsCousins {
    HashMap<Integer, Integer> depth;
    HashMap<Integer, TreeNode> parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<Integer, Integer>();
        parent = new HashMap<Integer, TreeNode>();
        dfs(root, null);
        return depth.get(x).equals(depth.get(y)) && !parent.get(x).equals(parent.get(y));
    }

    private void dfs(TreeNode node, TreeNode par) {
        if (null != node) {
            depth.put(node.val, par != null ? depth.get(par.val) + 1 : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public static void main(String[] args) {
        IsCousins task = new IsCousins();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        //TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        //node3.right = node5;

        boolean res = task.isCousins2(node1, 4, 3);
        System.out.println(res);
    }

    public boolean isCousins2(TreeNode root, int x, int y) {
        if (null == root) return false;
        TreeNode nodeX = null;
        TreeNode nodeY = null;
        TreeNode nodeXFather = null;
        TreeNode nodeYFather = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == x) {
                        nodeX = node.left;
                        nodeXFather = node;
                    }
                    if (node.left.val == y) {
                        nodeY = node.left;
                        nodeYFather = node;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == y) {
                        nodeY = node.right;
                        nodeYFather = node;
                    }
                    if (node.right.val == x) {
                        nodeX = node.right;
                        nodeXFather = node;
                    }
                }
                if (nodeX == null && nodeY == null) {
                } else if (nodeX != null && nodeY != null) return nodeXFather != nodeYFather;
                else if (size == 0) return false;
            }

        }
        return false;
    }


}

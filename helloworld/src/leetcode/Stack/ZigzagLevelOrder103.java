package leetcode.Stack;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @auther : wangyufei
 * @date : 2021-06-06
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ZigzagLevelOrder103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (null == root) return res;
        //正方向
        Stack<TreeNode> stack1 = new Stack<>();
        //反方向
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        int start = 0, end = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                list.add(node.val);
                start++;
                if (node.left != null) stack2.push(node.left);
                if (node.right != null) stack2.push(node.right);
                if (start == end) {
                    start = 0;
                    end = stack2.size();
                    res.add(list);
                    list = new ArrayList<>();
                }
            }
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                list.add(node.val);
                start++;
                if (node.right != null) stack1.push(node.right);
                if (node.left != null) stack1.push(node.left);
                if (start == end) {
                    start = 0;
                    end = stack1.size();
                    res.add(list);
                    list = new ArrayList<>();
                }
            }

            //分两个Stack count 混乱问题能解决了


        }
        return res;

    }

    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {

        return null;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        List<List<Integer>> lists = zigzagLevelOrder(node);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}

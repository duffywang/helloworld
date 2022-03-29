package leetcode.DFS;

import leetcode.TreeNode;

import java.util.ArrayList;

/**
 * @auther : wangyufei
 * @date : 2020-09-20
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeafSimilar872 {
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeafNoed(root1, list1);
        getLeafNoed(root2, list2);
        if (list1.size() != list2.size()) return false;
        int len = list1.size();
        for (int i = 0; i < len; i++) {
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
    }

    private void getLeafNoed(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) list.add(node.val);
        getLeafNoed(node.left, list);
        getLeafNoed(node.right, list);
    }
}

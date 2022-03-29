package leetcode.dp;

import leetcode.TreeNode;

import java.util.HashMap;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @auther : wangyufei
 * @date : 2020-02-02
 **/
public class HouseRobber337 {
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public static void main(String[] args) {


    }

    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * @param root
     * @return array[0]不抢root所得到最大钱； array[1]抢root所得的最多钱
     */
    private int[] dp(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int rob = root.val + left[0] + right[0];
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{not_rob, rob};
    }

    /**
     * 使用备忘录，可减少 ，代码更容易理解
     *
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int rob = root.val +
                (root.left == null ? 0 : rob2(root.left.left) + rob2(root.left.right)) +
                (root.right == null ? 0 : rob2(root.right.left) + rob2(root.right.right));
        int not_rob = rob2(root.left) + rob2(root.right);
        int res = Math.max(rob, not_rob);
        map.put(root, res);
        return res;

    }

}

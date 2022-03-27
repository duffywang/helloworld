package leetcode.BinaryTree;

import leetcode.TreeNode;

/**
 * @auther : wangyufei
 * @date : 2022-03-19
 * <p>
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Tree2str606 {

    public String tree2str(TreeNode root) {

        if (root == null) {
            return "";
        }
        //左右子树为空 不会增加()()这样
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        //只有左子树 右子树不用写()
        if (root.right == null) {
            return new StringBuilder().append(root.val).append("(").append(tree2str(root.left)).append(")").toString();
        }
        //左子树和右子树都有 以及 只有右子树的情况
        //注意根节点不用加括号
        return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")(").append(tree2str(root.right)).append(")").toString();

    }
}

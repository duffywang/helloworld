package leetcode.Tree;

/**
 * @auther : wangyufei
 * @date : 2022-02-12
 * <p>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 左子树比根节点小，右子树比根节点大
 * <p>
 * 输入：1
 * 输出：1
 * <p>
 * 输入：2
 * 输出：2
 * <p>
 * 1    2
 * 2  1
 * <p>
 * 输入：3
 * 输出：5
 * 2     1         3     1       3
 * 1 3     2       2        3   1
 * 3     1        2     2
 * <p>
 * 输入：4
 * 输出：14
 * 2     2   1         3    3    3     1       3
 * 1 3   1 3   2       2    2 4  2        3   1
 * 4   4     3     1 4  1    1        2     2
 * 4               4
 **/
public class NumTrees96 {
    public static int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - j - 1];//0*2 1*1 2*0
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}

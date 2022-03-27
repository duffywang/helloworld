package leetcode.dp;

/**
 * @auther : wangyufei
 * @date : 2021-06-11
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * <p>
 * 对于可以选择重复的，一般可以额用类似dp[i] = dp[i-j]
 * dp[2] = dp[1] + dp[1]
 * <p>
 * change518 外层是钱币的种类1、2、5，外层循环一次说明此次只能选择这种金额的钱币，内层是总金额
 * 这道题外层需要达到的数字，内层是可以选择的完全平方数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NumSquares279 {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
//
//    public static int numSquares2(int n) {
//        int i = 1;
//        for (; i < 35; i++) {
//            if (i * i > n) break;
//        }
//        int[] dp = new int[n + 1];
//        for (int j = 0; j < i; j++) {
//            int min = Integer.MAX_VALUE;
//            for (int k = 0; k <= n; k++) {
//                dp[k] = Math.min(min, dp[k - j * j]);
//            }
//            dp[k]
//        }
//        return dp[n];
//    }


    public static void main(String[] args) {
        int res = numSquares(12);
        System.out.println(res);

    }
}

package leetcode.dp;

/**
 * @auther : wangyufei
 * @date : 2021-06-10
 * <p>
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * <p>
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * dp[1]=1 dp[2]=1 dp[3]=1 dp[4]=1 dp[5]=1
 * dp[2]=2 dp[3]=2 dp[4]=3 dp[5]=dp[5] +dp[3] = 3
 * dp[5]=dp[5]+dp[0]=4
 **/
public class Change518 {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        //dp[0] 为用一种货币达到0元，不选这个货币就可以了
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int res = change(5, coins);
        System.out.println(res);
    }
}

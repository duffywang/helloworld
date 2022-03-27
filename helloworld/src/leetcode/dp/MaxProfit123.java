package leetcode.dp;

/**
 * @auther : wangyufei
 * @date : 2020-08-29
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * <p>
 * dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k-1][1] + prices[i]);
 * dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k][0] - prices[i]);
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxProfit123 {
    public static int maxProfit(int[] prices, int k) {

        int len = prices.length;
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i < len; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    //买入的时候次数-1
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[len - 1][k][0];

    }


    /**
     * 只有两次买卖机会
     * dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + price);
     * dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - price);
     * dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + price);
     * dp[i][1][1] = Math.max(dp[i-1][1][1], - price);
     **/
    public static int maxProfit2(int[] prices, int k) {
        int dp20 = 0, dp21 = Integer.MIN_VALUE;
        int dp10 = 0, dp11 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp20 = Math.max(dp20, dp21 + price);
            dp21 = Math.max(dp21, dp10 - price);
            dp10 = Math.max(dp10, dp11 + price);
            dp11 = Math.max(dp11, -price);
        }
        return Math.max(dp10, dp20);

    }


    public static void main(String[] args) {
        int[] array = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit2(array, 1));
    }
}

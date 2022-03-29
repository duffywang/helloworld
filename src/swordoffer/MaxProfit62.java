package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-08-20
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxProfit62 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int min = Integer.MAX_VALUE;
        int diff = 0;
        for (int i = 0; i < len; i++) {
            //最后使用的最小值不一定是全局最小值
            //2,5,9,1,4
            if (prices[i] < min) min = prices[i];
            diff = Math.max(diff, prices[i] - min);
        }
        return diff;
    }

    /**
     * dp[i][0] 表示第i天不持有 ：第i-1天就没有持有 OR 第i天卖掉了
     * dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1] + prices[i])
     * dp[i][1] 表示第天持有 : 第i-1天就持有 OR 第i天买了
     * dp[i][1] = Math.max(dp[i-1][1], prices[i])
     **/
    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1) return 0;
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, -prices[i]);

        }
        return dp0;

    }


    public static void main(String[] args) {
        int[] array = {2, 5, 9, 1, 4};
        int res = maxProfit(array);
        System.out.println(res);
    }
}

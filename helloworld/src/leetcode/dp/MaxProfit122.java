package leetcode.dp;

/**
 * @auther : wangyufei
 * @date : 2020-08-29
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 第2天买第3天卖，第4天买第5天卖，相比与只能买卖一次，无数次买入与卖出 k ~ k-1
 * 详细：https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/tuan-mie-gu-piao-wen-ti
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxProfit122 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int temp = dp0;
            //继续不买 OR 卖出
            dp0 = Math.max(dp0, dp1 + prices[i]);
            //继续持有 OR 买入
            dp1 = Math.max(dp1, temp - prices[i]);
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(array);
        System.out.println(res);
    }
}

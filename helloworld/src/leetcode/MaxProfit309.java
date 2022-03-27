package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-08-29
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxProfit309 {
    public static int maxProfit(int[] prices){
        int len = prices.length;
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        int dppre = 0;
        for (int i = 0; i < len; i++) {
            //控制买入至少在卖出晚一天
            int temp = dp0;
            //继续不买 OR 卖出
            dp0 = Math.max(dp0, dp1 + prices[i]);
            //继续持有 OR 买入
            dp1 = Math.max(dp1, dppre - prices[i]);
            dppre = temp;
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,0,2};
        System.out.println(maxProfit(array));
    }
}

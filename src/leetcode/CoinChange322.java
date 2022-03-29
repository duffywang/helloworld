package leetcode;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * input:[1,2,5] 11
 * output:3 (5+5+1)
 *
 * @auther : wangyufei
 * @date : 2020-02-06
 **/
public class CoinChange322 {
    public static void main(String[] args) {
        int[] coins = {2};
        int res = coinChange(coins, 3);
        System.out.println(res);

    }

    /**
     * 贪心算法此题不正确 {1, 3, 4} 6 = 4 + 1 + 1 > 3 + 3
     *
     * @param coins  所有的硬币类型 不变
     * @param amount 总量 不变
     * @param size   采用硬币类型
     * @return
     */
    public static int coinChange(int[] coins, int amount, int size) {
        if (coins == null) return -1;
        Arrays.sort(coins);
        int sum = amount;
        int count = 0;
        int res = 0;
        int i = size - 1;
        for (; i >= 0; i--) {
            if ((res = amount / coins[i]) >= 1) {
                count += res;
                amount = amount - res * coins[i];
            }
            if (amount == 0) {
                return count;
            }
        }
        if (i == 0) return -1;
        return coinChange(coins, sum, size - 1);

    }


    /**
     * 动态规划算法 从1到amount记录每个总量最少用币数量
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        //[0,1,2,3,4,5,6] 外循环
        //[0,1,2,1,2,2,2] f
        int[] f = new int[amount + 1];
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int cost = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && f[i - coins[j]] != Integer.MAX_VALUE) {
                    cost = Math.min(cost, f[i - coins[j]] + 1);
                }
            }
            //如果钱小于货币的最小值，则设为最大值
            f[i] = cost;
        }
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }

}

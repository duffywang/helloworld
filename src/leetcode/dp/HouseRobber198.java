package leetcode.dp;

/**
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * input:[1,2,3,1]
 * output:4  (1+3)
 *
 * @auther : wangyufei
 * @date : 2020-02-01
 **/
public class HouseRobber198 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int res = rob(nums);
        System.out.println(res);

    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len == 0 ? 0 : nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if (len == 2) return dp[1];
        for (int i = 2; i < len; i++) {
            //从底到顶的构建 ：抢这家和不抢这家
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}

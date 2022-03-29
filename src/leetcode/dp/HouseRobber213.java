package leetcode.dp;

/**
 * 这个地方所有的房屋都围成一圈，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * input:[2,3,2]
 * output:3
 * 三种方式：
 * 一、不偷前后两家的（舍弃，多一种选项为何不好）
 * 二、不偷最后一家的
 * 三、不偷第一家的
 *
 * @auther : wangyufei
 * @date : 2020-02-01
 **/
public class HouseRobber213 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        int res = rob(nums);
        System.out.println(res);

    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len == 0 ? 0 : nums[0];
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        if (len == 2) return dp1[1];
        dp2[0] = 0;
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[2], nums[1]);
        //方案二
        for (int i = 2; i < len - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }
        //方案三
        for (int i = 3; i < len; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }
        //注意dp1 与 dp2 的index不同
        return Math.max(dp1[len - 2], dp2[len - 1]);
    }

}

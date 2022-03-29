package leetcode.dp;

/**
 * @auther : wangyufei
 * @date : 2020-10-06
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 **/
public class LengthOfLIS300 {
    public static int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if (len == 0 || len == 1) return len;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //注意，比之前nums[j]大，取其结果
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            //添加自己后序列长度
            dp[i] = maxval + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 2, 0, 4};
        int res = lengthOfLIS(array);
        System.out.println(res);
    }

}

package leetcode.dp;

/**
 * @auther : wangyufei
 * @date : 2021-07-19
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 **/
public class MaxSubArray53 {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > 0) {
                sum += nums[i];
            } else {
                sum = 0;
            }
            max = Math.max(max, sum);
            maxNum = Math.max(maxNum, nums[i]);
        }
        return max == 0 ? maxNum : max;
    }

    public static void main(String[] args) {
        int[] array = {-2, -1};
        int res = maxSubArray(array);
        System.out.println(res);
    }
}

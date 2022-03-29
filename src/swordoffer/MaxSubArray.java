package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-07-19
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 **/
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : nums) {
            temp += num;
            //当前值和之前值做比较（一顿操作猛如虎，还不如个小蘑菇）
            temp = Math.max(temp, num);
            if (temp > max) max = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = maxSubArray(array);
        System.out.println(res);
    }

    public static int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] array = new int[nums.length];
        int temp = 0;
        for (int num : nums) {
            temp += num;
            //当前值和之前值做比较（一顿操作猛如虎，还不如个小蘑菇）
            temp = Math.max(temp, num);
            if (temp > max) max = temp;
        }
        return max;
    }
}

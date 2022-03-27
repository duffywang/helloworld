package leetcode;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）
 * input:[2,3,-2,4]
 * output:6
 *
 * @auther : wangyufei
 * @date : 2020-02-16
 **/
public class MaxProductSubarray152 {
    public static void main(String[] args) {
        int[] nums = {2, -3, 2, -4};
        int res = maxProduct2(nums);
        System.out.println(res);


    }

    public static int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int pro = 1;
            for (int j = i; j < len; j++) {
                pro *= nums[j];
                if (pro > res) res = pro;
            }
        }
        return res;
    }

    public static int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int mini = 1, maxi = 1;
        for (int i = 0; i < nums.length; i++) {
            //由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin
            if (nums[i] < 0) {
                int temp = maxi;
                maxi = mini;
                mini = temp;
            }
            maxi = Math.max(maxi * nums[i], nums[i]);
            mini = Math.min(mini * nums[i], nums[i]);
            max = Math.max(maxi, max);
        }
        return max;

    }

}

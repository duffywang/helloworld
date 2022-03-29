package leetcode;

import java.util.Arrays;

/**
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1(提示：取中位数)
 * input:[1,2,3]
 * [1,2,3] [2,2,3] [2,2,2]
 * output:2
 * <p>
 * input:[1,2,3,4]
 * output:4 ([2,2,3,4] [2,2,2,4] [2,2,2,3] [2,2,2,2]) ([2,2,3,4] [2,2,3,3] [2,3,3,3] [3,3,3,3])
 *
 * @auther : wangyufei
 * @date : 2020-01-28
 **/
public class MinMoves462 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int res = minMoves2(nums);
        System.out.println(res);
    }

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int sum = 0;
        while (i < j) {
            sum += nums[j--] - nums[i++];
        }
        return sum;
    }
}

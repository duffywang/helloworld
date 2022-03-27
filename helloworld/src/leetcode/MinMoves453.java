package leetcode;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
 * input:[1,2,3]
 * [1,2,3] -> [2,3,3] -> [3,4,3] -> [4,4,4]
 * output:3
 * [1,2,3,5] 4 3 2
 * [2,3,4,5] [3,4,5,5] [4,5,6,5] [5,6,6,6] [6,7,7,6] [7,7,8,7] [8,8,8,8]
 * <p>
 * [-1,2,4]
 * [0,3,4] [1,4,4] [2,5,4] [3,5,5] [4,6,5] [5,6,6] [6,7,6] [7,7,7]
 *
 * @auther : wangyufei
 * @date : 2020-01-28
 **/
public class MinMoves453 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        int res = minMoves(nums);
        System.out.println(res);

    }

    public static int minMoves(int[] nums) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i] - nums[0];
        }
        return sum;


    }
}

package leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * input:{2, 6, 4, 8, 10, 9, 15}
 * output:5 {6,4,8,10,9}子序列需要重新排序
 *
 *
 * @auther : wangyufei
 * @date : 2020-02-02
 **/
public class UnsortedSubarray581 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int res = findUnsortedSubarray2(nums);
        System.out.println(res);

    }

    public static int findUnsortedSubarray(int[] nums) {
        int l = nums.length;
        int r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //右边的比左边的小，需要调整
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l + 1;
    }

    /**
     * {2, 6, 4, 8, 10, 9, 15}
     * {2, 4, 6, 8, 9, 10, 15}
     * 排序后对不上的index进行记录
     * **/
    public static int findUnsortedSubarray2(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != snums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start >= 0 ? end - start + 1 : 0;
    }
}
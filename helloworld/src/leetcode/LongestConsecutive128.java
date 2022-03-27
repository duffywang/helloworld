package leetcode;

import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2020-05-20
 **/
public class LongestConsecutive128 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 0};
        System.out.println(longestConsecutive(nums));

    }

    public static int longestConsecutive(int[] nums) {

        int max = 1;
        int len = nums.length;
        if (len == 0) return 0;
        int current = 1;
        Arrays.sort(nums);
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1] ) {
                if (nums[i] == nums[i - 1] + 1){
                    current++;
                }else {
                    max = Math.max(max, current);
                    current = 1;
                }
            }

        }
        return Math.max(max, current);


    }
}

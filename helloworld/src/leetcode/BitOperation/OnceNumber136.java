package leetcode.BitOperation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @auther : wangyufei
 * @date : 2020-01-22
 **/
public class OnceNumber136 {
    public static void main(String[] args) {
        int[] input = {2, 2, 1, 3, 3, 1, 4};
        int res = getOnceNumber2(input);
        System.out.println(res);
    }

    public static int getOnceNumber(int[] input) {
        int length = input.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            res = input[i] ^ res;
        }
        return res;
    }

    public static int getOnceNumber2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                i++;
                continue;
            }
            break;
        }
        return nums[i];
    }

    public static int getOnceNumber3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();

    }


}

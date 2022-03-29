package leetcode;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * input:[3,2,3]
 * output:3
 * <p>
 * 方法二：从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
 *
 * @auther : wangyufei
 * @date : 2020-02-01
 **/
public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 3, 4, 3};
        int res = majorityElement2(nums);
        System.out.println(res);

    }

    public static int majorityElement0(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len % 2 == 1) {
            return nums[len / 2];
        } else {
            int a = nums[len / 2];
            int b = nums[len / 2 - 1];
            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] == a) {
                    sumA++;
                    continue;
                }
                if (nums[i] == b) {
                    sumB++;
                    continue;
                }
            }
            return sumA > sumB ? a : b;
        }

    }

    /**
     * 摩尔投票法
     * 数组中每一个数字代表一个国家，数字的个数就代表这个国家的人数，在一起混战，每两个两个同归于尽，那么人数大于数组长度一半的国家最终肯定会获胜。
     */
    public static int majorityElement2(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (count == 0) {
                count++;
                res = nums[i];
            } else if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

}

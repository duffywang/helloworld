package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @auther : wangyufei
 * @date : 2020-06-07
 **/
public class FirstPositiveNum41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) return 1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] array = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            array[index++] = i;
        }

        Arrays.sort(array);
        if (array[0] > 1) return 1;

        int temp = 1;
        for (int i = 0; i < set.size(); i++) {
            if (array[i] <= 0) continue;

            if (temp == array[i]) {
                temp++;
            } else {
                return temp;
            }
        }
        return temp;
    }

    public static int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        if (len == 0) return 1;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        int i = 0;
        for (; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        int[] nums2 = {0, 1, 1, 2, 2};
        int[] nums3 = {5, 7, 8, 9};
        int[] nums4 = {1, 7, 8, 9};
        System.out.println(firstMissingPositive2(nums) + "   ans= 3");
        System.out.println(firstMissingPositive2(nums2) + "   ans= 3");
        System.out.println(firstMissingPositive2(nums3) + "   ans= 1");
        System.out.println(firstMissingPositive2(nums4) + "   ans= 2");

        //System.out.println(String.valueOf(null));
        System.out.println(Integer.parseInt(null));


    }

}

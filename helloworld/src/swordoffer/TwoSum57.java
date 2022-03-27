package swordoffer;

import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2020-08-16
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 **/
public class TwoSum57 {
    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }

        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 5, 4, 7, 9, 8};
        int[] res = bubbleSort(array);

        for (int re : res) {
            System.out.print(re);
        }
    }

    public static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}


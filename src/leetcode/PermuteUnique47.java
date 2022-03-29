package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-09-08
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 **/
public class PermuteUnique47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, temp, nums, 0);
        return res;
    }

    private static void helper(List<List<Integer>> rst, List<Integer> list, int[] nums, int start) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums, i, start);
            list.add(nums[start]);
            helper(rst, list, nums, start + 1);
            swap(nums, i, start);
            list.remove(list.size() - 1);
        }
    }

    private static void swap(int[] nums, int i, int start) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 1};
        List<List<Integer>> res = permuteUnique(array);
        System.out.println(res);
    }
}

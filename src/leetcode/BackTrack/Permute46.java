package leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-09-08
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Permute46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return rst;
        //helper(rst, new ArrayList<Integer>(), nums);
        helper2(rst, new ArrayList<>(), nums, 0);
        return rst;
    }

    private static void helper2(List<List<Integer>> rst, ArrayList<Integer> list, int[] nums, int start) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            /**
             * 与78题对比
             * 需要交换
             *
             * nums[start] start + 1
             * nums[i] i + 1
             * */
            swap(nums, i, start);
            list.add(nums[start]);
            helper2(rst, list, nums, start + 1);
            swap(nums, i, start);
            list.remove(list.size() - 1);
        }
    }

    private static void swap(int[] nums, int i, int start) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }

    public static void helper(List<List<Integer>> rst, ArrayList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));

        }

        for (int i = 0; i < nums.length; i++)
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                helper(rst, list, nums);
                list.remove(list.size() - 1);
            }
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        List<List<Integer>> res = permute(array);
        System.out.println(res);
    }
}

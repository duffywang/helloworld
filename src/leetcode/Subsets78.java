package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-09-07
 **/
public class Subsets78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        helper(res, tempList, nums, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        res.add(new ArrayList<Integer>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            helper(res, tempList, nums, i + 1);
            //组合问题，每次递归完成后需要remove
            tempList.remove(tempList.size() - 1);

        }
    }

    public static List<List<Integer>> subsets2(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    public static List<List<Integer>> subsets3(int[] nums) {
        int size = nums.length;
        int n = 1 << size;
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) == 1) {
                    cur.add(nums[j]);
                }
            }
            res.add(cur);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        List<List<Integer>> res = subsets3(array);
        for (List<Integer> re : res) {
            System.out.println(res);
        }
    }


}

package leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * input:nums = [1,1,1], k = 2
 * output:2
 * <p>
 * 方法一：前缀和思路，主要解决数组区间的问题，用map 记录前缀和
 * 前缀法也可用于计算计算考试分段学生人数
 *
 * @auther : wangyufei
 * @date : 2020-02-15
 **/
public class SubarraySum560 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3};
        int res = subarraySum(nums, 3);
        System.out.println(res);

    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//如果k为0说明从头开始的子数组和为k
        int sum = 0, ret = 0;

        for (int i = 0; i < nums.length; ++i) {
            //前缀和 nums = {1,2,1,3}的mapKeys{0,1,3,4,7}
            sum += nums[i];
            if (map.containsKey(sum - k))//任何一个数组都可以由sum_i - sum_j构成，k 也就相当于子数组和的值
                ret += map.get(sum - k); //3-3 = 0、 4-3=1 有两个结果
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ret;

    }

    public static int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;

    }

}

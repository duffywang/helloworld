package leetcode;

import java.util.HashMap;

/**
 * @auther : wangyufei
 * @date : 2020-10-07
 * <p>
 * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，
 * 其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * <p>
 * 输入：[23,2,4,6,7], k = 6
 * 输出：True
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 * <p>
 * 输入：[23,2,6,4,7], k = 6
 * 输出：True
 * 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 * <p>
 * 这道题没有要求算个数，map的value 存储的是下标，用于控制大小个数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CheckSubarraySum523 {
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        }
        if (k == 0) return false;
        if (k < 0) k = -k;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            //说明之前存在相同的mod,相减即可整除
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    //确定大小至少为2
                    return true;
                }
            } else {
                map.put(mod, i);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {23, 2, 4, 6, 7};//{0,23,25,29,35,42} -> {0,5,1,5,5,0}
        boolean res = checkSubarraySum(array, 6);
        System.out.println(res);
    }

}

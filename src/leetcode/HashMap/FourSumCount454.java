package leetcode.HashMap;

import java.util.HashMap;

/**
 * @auther : wangyufei
 * @date : 2022-02-06
 * <p>
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FourSumCount454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> ABMap = new HashMap<>();
        int res = 0;
        for (int a : nums1) {
            for (int b : nums2) {
                if (ABMap.containsKey(a + b)) {
                    ABMap.put(a + b, ABMap.get(a + b) + 1);
                } else {
                    ABMap.put(a + b, 1);
                }
            }
        }

        for (int c : nums3) {
            for (int d : nums4) {
                int temp = -c - d;
                if (ABMap.containsKey(temp)) {
                    res += ABMap.get(temp);
                }
            }
        }
        return res;
    }
}

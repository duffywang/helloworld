package leetcode.LeftRightPoint;

/**
 * @auther : wangyufei
 * @date : 2020-09-26
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中「优美子数组」的数目。
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * <p>
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NumberOfSubarrays1248 {
    public static int numberOfSubarrays(int[] nums, int k) {
        int cnt = 0;
        int len = nums.length;
        int sum = 0;
        int[] odd = new int[len + 2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) odd[++cnt] = i;
        }
        odd[0] = -1;
        odd[++cnt] = len;
        for (int i = 1; i + k <= cnt; i++) {
            sum += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] array = {2,2,2,1,2,2,1,2,2,2};//-1 3 6 10 = 4 * 4 = 16
        int res = numberOfSubarrays(array, 3);
        System.out.println(res);
    }
}

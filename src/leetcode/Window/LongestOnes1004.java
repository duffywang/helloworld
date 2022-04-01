package src.leetcode.Window;

/**
 * @auther : wangyufei
 * @date : 2022-03-30
 *
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LongestOnes1004 {
    /**
    * 滑动窗，虫取法，前脚不动，把后脚移动过来；后脚不动，把前脚向前移动
    * 滑动窗的模板👇
    * */
    public static int longestOnes(int[] nums, int k) {
        int len = nums.length,left = 0,right = 0,res = 0,sum = 0;
        for (; right < len; right++) {
            sum += nums[right] != 1 ? 1 : 0;
            while (sum > k){
                sum -= nums[left++] != 1 ? 1 : 0;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    /**
     * 滑动窗变式
     *
     * */
    public static int longestOnes2(int[] nums, int k) {
        int left = 0,right = 0;
        while(right < nums.length){
            if(nums[right++] == 0)k--;
            if(k < 0 && nums[left++] == 0)k++;
        }
        return right - left;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 2));
    }
}

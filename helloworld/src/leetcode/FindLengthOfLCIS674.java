package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-10-06
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FindLengthOfLCIS674 {
    public static int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int len = nums.length;
        int i = 0;
        if (len == 0 || len == 1) return len;
        for (; i < len - 1; i++) {
            int count = 0;
            while (i < len - 1 && nums[i] < nums[i + 1]) {
                count++;
                max = Math.max(max, count);
                i++;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 4, 7};
        int res = findLengthOfLCIS(array);
        System.out.println(res);
    }
}

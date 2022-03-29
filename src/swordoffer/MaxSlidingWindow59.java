package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-08-19
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 1、现在一开始找到最大值及最大值的所在坐标
 * 2、向右移动一位时，判断这个位是否会更新最大值和坐标；判断移动一位后是否丢失了最大值，重新选择最大值
 * 注意：记录最大值和最大值所在坐标
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 **/
public class MaxSlidingWindow59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] res = new int[len - k + 1];
        int i, j;
        int maxPos = -1;
        for (i = 0; i < len - k + 1; i++) {
            //滑动窗右边范围
            j = i + k - 1;
            //最大值是最右的窗的数据
            if (maxPos != -1 && nums[j] >= nums[maxPos]) {
                maxPos = j;
                res[i] = nums[maxPos];
            } else if (i <= maxPos) {
                //最大值在窗内
                res[i] = nums[maxPos];
            } else {
                //新的窗内选取最大值
                int maxWindow = Integer.MIN_VALUE;
                int temp = 0;
                for (int z = i; z <= j; z++) {
                    if (nums[z] > maxWindow) {
                        temp = z;
                        maxWindow = nums[z];
                    }
                }
                maxPos = temp;
                res[i] = maxWindow;
            }
        }
        return res;
    }
}

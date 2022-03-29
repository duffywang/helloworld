package leetcode.BackTrack;

/**
 * @auther : wangyufei
 * @date : 2021-06-07
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FindTargetSumWays494 {
    static int count = 0;

    /**
     * 时间复杂度为O(2^N)
     * 空间复杂度为O(N)
     * 取一个数有2个结果，取两个数有4个结果，取三个数有8个结果......
     */
    public static int findTargetSumWays(int[] nums, int target) {
        backHelper(nums, target, 0, 0);
        return count;
    }

    private static void backHelper(int[] nums, int target, int index, int sum) {
        //不会越界，因为当index == nums.length 时会走这个分支
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            //递归深度 = 数组中元素个数
            backHelper(nums, target, index + 1, sum + nums[index]);
            backHelper(nums, target, index + 1, sum - nums[index]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int res = findTargetSumWays(nums, 3);
        System.out.println(res);
    }

}

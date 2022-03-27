package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther : wangyufei
 * @date : 2021-07-17
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 *
 * 和我们来看看，打家劫舍的最优子结构的公式：
 *
 * dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
 *
 * 再来看看现在对这个问题的最优子结构公式：
 *
 * dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class DeleteAndEarn740 {
    public static int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }
        int[] array = new int[max + 1];
        for (int num : nums) {
            array[num]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = array[1] * 1;
        dp[2] = Math.max(dp[1], array[2] * 2);
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], array[i] * i + dp[i - 2]);
        }
        return dp[max];

    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        int res = deleteAndEarn(nums);
        System.out.println(res);
    }
}

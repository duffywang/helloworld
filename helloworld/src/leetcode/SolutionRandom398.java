package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @auther : wangyufei
 * @date : 2020-10-11
 * <p>
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * <p>
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 * <p>
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SolutionRandom398 {
    private int[] nums;

    public SolutionRandom398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {

        int i = 0, res = 0;
        Random random = new Random();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == target && random.nextInt(++i) == 0) res = j;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {5, 1, 2, 4, 5, 1, 2, 5, 2, 5, 1};
        SolutionRandom398 obj = new SolutionRandom398(array);
        int pick = obj.pick(1);
        System.out.println(pick);
    }
}

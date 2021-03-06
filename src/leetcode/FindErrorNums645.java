package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-10-09
 * <p>
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * <p>
 * 思路：用
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FindErrorNums645 {

    public static int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int dup = -1;
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] = -1 * nums[index];
            }
        }
        int missing = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        return new int[]{dup, missing};
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 4};
        int[] res = findErrorNums(array);
        for (int re : res) {
            System.out.println(re);
        }
    }
}

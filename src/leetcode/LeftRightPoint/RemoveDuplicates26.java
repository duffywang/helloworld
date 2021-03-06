package leetcode.LeftRightPoint;

/**
 * @auther : wangyufei
 * @date : 2020-10-05
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class RemoveDuplicates26 {
    public int removeDuplicates(int[] nums) {
        int fast = 0, slow = 0;
        int len = nums.length;
        while (fast < len) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return ++slow;

    }
}

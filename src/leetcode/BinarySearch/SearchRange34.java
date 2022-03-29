package leetcode.BinarySearch;

/**
 * @auther : wangyufei
 * @date : 2021-07-28
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * <p>
 * 寻找右边界和左边界
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SearchRange34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    private static int binarySearch(int[] nums, int target, boolean leftFlag) {
        int res = -1;
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            //特殊处理
            if (nums[mid] == target) {
                res = mid;
                if (leftFlag) {
                    //找到左边界极限
                    right = mid - 1;
                } else {
                    //找到右边界极限
                    left = mid + 1;
                }
                //常规操作
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 7, 8, 8, 10};
        int[] res = searchRange(array, 8);
        System.out.println(res[0] + " " + res[1]);
    }
}

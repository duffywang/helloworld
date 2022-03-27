package leetcode;

import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2020-09-06
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Search704 {
    public int search(int[] nums, int target) {
        return Arrays.binarySearch(nums, target) < 0 ? -1 : Arrays.binarySearch(nums, target);
    }

    public static int search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {-1, 0, 3, 5, 9, 12};
        int res = search2(array, 9);
        System.out.println(res);

    }
}

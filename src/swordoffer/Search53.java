package src.swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-08-15
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 **/
public class Search53 {
    // public int search(int[] nums, int target) {
    //     int res = 0;
    //     for(int num : nums){
    //         if (num == target){
    //             res++;
    //         }
    //         if(num > target)break;
    //     }
    //     return res;
    // }
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = 0;
        int mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            //通过二分法找到第一次出现这个数的下标，时间复杂度低于全量遍历
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        while (l < nums.length && nums[l++] == target) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 7, 8, 8, 10};
        int search = search(array, 7);
        System.out.println(search);
    }
}

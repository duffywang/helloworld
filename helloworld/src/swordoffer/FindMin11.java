package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-07-18
 **/
public class FindMin11 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        if (len == 1 || nums[right] > nums[left]) return nums[0];
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;

    }
}

package leetcode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * input:[1,0,3,0,8]
 * output:[1,3,8,0,0]
 *
 * @auther : wangyufei
 * @date : 2020-02-02
 **/
public class MoveZeros283 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 0, 8};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) return;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            if (count > 0) {
                nums[i - count] = nums[i];
            }
        }
        for (int i = len - count; i < len; i++) {
            nums[i] = 0;
        }
    }
}

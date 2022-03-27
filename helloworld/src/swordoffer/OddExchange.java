package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-07-19
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 **/
public class OddExchange {
    public static int[] exchange(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l < r) {
            while(l < r && !isEven(nums[l])) l++;
            while(l < r && isEven(nums[r])) r--;
            if (l < r) position(nums, l, r);
        }
        return nums;

    }

    private static void position(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        int[] array = {1,3,2,4};
        int[] res = exchange(array);
        for (int re : res) {
            System.out.println(re);
        }
    }
}

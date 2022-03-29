package leetcode;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * input:[1,2,3,4]
 * output:[24,12,8,6]
 *
 * @auther : wangyufei
 * @date : 2020-02-05
 **/
public class ProductofArray238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf2(nums);
        for (int re : res) {
            System.out.println(re);
        }

    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        for (int j = len - 2; j >= 0; j--) {
            right[j] = nums[j + 1] * right[j + 1];
        }
        for (int k = 0; k < len; k++) {
            res[k] = left[k] * right[k];
        }
        return res;

    }

    public static int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = R * res[i];
            R *= nums[i];
        }
        return res;

    }

}

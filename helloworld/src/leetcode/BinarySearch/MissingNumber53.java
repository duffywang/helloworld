package leetcode.BinarySearch;

/**
 * @auther : wangyufei
 * @date : 2020-10-08
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MissingNumber53 {
    /**
     * 有序数组使用二分法*/
    public static int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    /**
     * 小红书一面
     * 无序的数组中找到缺失的数字，与下标与数字做异或，构成其他数都是双数，只有缺失数为单数的问题*/
    public static int missingNumber2(int[] nums) {
        int len = nums.length;
        int res = 0;
        res ^= len;
        for (int i = 0; i < len; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    /**
     * 当时使用的等差数组求合和
    * */
    public static int missingNumber3(int[] nums) {
        int len = nums.length;
        int expect = (len+1) * len /2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return expect - sum;
    }


    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int res = missingNumber3(array);
        System.out.println(res);
    }

}

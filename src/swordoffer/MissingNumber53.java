package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-08-15
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 已经排好序了 不是乱序的
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MissingNumber53 {
    public int missingNumber(int[] nums) {
        if (nums[0] != 0) return 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) return i;
        }
        return len;
    }
}

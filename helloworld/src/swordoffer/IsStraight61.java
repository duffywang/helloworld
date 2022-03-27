package swordoffer;

import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2020-09-06
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class IsStraight61 {
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int diff = 0;
        for (int num : nums) {
            if (num == 0) count++;
        }
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] == nums[i + 1]) return false;
            if (nums[i] + 1 != nums[i + 1]) {
                diff += nums[i + 1] - nums[i] - 1;
            }
        }
        return count >= diff;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 4, 0};
        boolean res = isStraight(array);
        System.out.println(res);
    }
}

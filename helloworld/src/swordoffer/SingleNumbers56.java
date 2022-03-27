package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-08-15
 * <p>
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 **/
public class SingleNumbers56 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int mask = 1;
        //两个不同的数异或后不可能为0，找到一个位上为1
        while ((mask & sum) == 0) {
            mask <<= 1;
        }
        //分成mask位有1的和mask位没有1的，用a,b记录结果
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a = a ^ num;
            } else {
                b = b ^ num;
            }
        }
        return new int[]{a, b};
    }
}

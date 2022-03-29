package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-07-19
 * <p>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * https://leetcode-cn.com/problems/integer-break/
 **/
public class IntegerBreak {
    public static int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int res = 1;
        while (n > 4) {
            n -= 3;
            res *= 3;
        }
        return n * res;
    }

    public static void main(String[] args) {
        int res = integerBreak(10);
        System.out.println(res);
    }
}

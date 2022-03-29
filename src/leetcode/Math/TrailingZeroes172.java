package leetcode.Math;

/**
 * @auther : wangyufei
 * @date : 2022-02-08
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 **/
public class TrailingZeroes172 {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
}

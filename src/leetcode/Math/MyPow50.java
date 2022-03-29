package leetcode.Math;

/**
 * @auther : wangyufei
 * @date : 2022-02-09
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 * <p>
 * 成龙在博多吃饭时候说的，原始计算是一步一步相乘，考虑提高效率
 * 举个栗子：2*2*2*2*2*2*2*2*2*2
 * 可以利用已经得到的结果2*2 、2*2*2*2
 * 如果此时n是偶数，直接把上次递归得到的值算个平方返回即可，如果是奇数，则还需要乘上个x的值
 * <p>
 * https://leetcode-cn.com/problems/powx-n/
 **/
public class MyPow50 {
    public static double myPow(double x, int n) {
        double res = 1.0;
        //循环对折
        for (int i = n; i != 0; i /= 2) {
            //i肯定会到1的
            if (i % 2 != 0) {
                res *= x;
            }
            //结果双倍扩大
            x *= x;
        }
        //n有可能为负数，对于n是负数的情况，我们可以先用其绝对值计算出一个结果再取其倒数即可
        return n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
    }
}

package leetcode.BitOperation;

/**
 * @auther : wangyufei
 * @date : 2022-01-24
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 **/
public class GetSum371 {
    public static int getSum(int a, int b) {
        int sum, carry;
        /*
        * a = 1; b = 3
        *  01   10   00
        *  11   10  100
        * -------------
        *  10   00  100
        * 0+1 1+0加的正常展示，0有可能是0+0或者1+1，需要区分
        * */
        sum = a ^ b;

        /*
        * 01   10  000
        * 11   10  100
        * -------------
        * 01   10  000
        * --------------
        * 10  100  000
        *
        * &为1的说明要向前进一位
        * */
        carry = (a & b) << 1;

        if (carry != 0) {
            //还有进位继续算
            return getSum(sum, carry);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(196, 296));
    }
}

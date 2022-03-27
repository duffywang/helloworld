package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-07-19
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * 考察点在于与（&） 和向右意味（>>>）
 * >> 为带符号右移3位    >>>为就向右移3位
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 **/
public class HammingWeight191 {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            //count += n % 2;
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        //如果为负数怎么样 先变成正数
        int res = hammingWeight(11);
        System.out.println(res);

    }

}

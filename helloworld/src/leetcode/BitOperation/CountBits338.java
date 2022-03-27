package leetcode.BitOperation;

/**
 * @auther : wangyufei
 * @date : 2021-06-01
 * <p>
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 解释: 数字里分别是0~5，二进制包含的1的个数
 **/
public class CountBits338 {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = getBitCount(i);
        }
        return res;
    }

    /**
     * Brian Kernighan算法
     * 对于任意整数x 令 x = x & (x-1)，该运算将x的二进制表示的最后的一个1变成0，对x重复该操作，直到x变成0
     * */
    public int getBitCount(int pos) {
        int count = 0;
        while (pos > 0) {
            pos &= (pos - 1);
            count++;
        }
        return count;
    }



}

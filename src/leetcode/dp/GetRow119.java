package leetcode.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2022-03-18
 * <p>
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 **/
public class GetRow119 {
    public static List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < dp.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(3);
    }
}

package leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2022-02-15
 * <p>
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * <p>
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 * <p>
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * <p>
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LuckyNumbers1380 {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            boolean flag = true;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIndex = j;
                }
            }
            for (int k = 0; k < row; k++) {
                if (k == i) continue;
                if (matrix[i][minIndex] < matrix[k][minIndex]) {
                    flag = false;
                }
            }
            if (flag) {
                res.add(matrix[i][minIndex]);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] array = {{7, 8}, {1, 2}};
        List<Integer> res = luckyNumbers(array);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}

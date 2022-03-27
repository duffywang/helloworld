package leetcode.Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @auther : wangyufei
 * @date : 2021-04-18
 *
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaximalRectangle85 {
    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0)return 0;
        int col = matrix[0].length;
        int max = 0 ;
        int[]  heights = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1'){
                    heights[j] += 1;
                }else {
                    //断层了
                    heights[j] = 0;
                }
            }

            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;

    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            //之前的大于现在的，左边的大于右边的，相当于右边的小于左边的
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;

    }

    public static void main(String[] args) {
        char[][] matrix = {{'0','1'},{'1','0'}};
        int res = maximalRectangle(matrix);
        System.out.println(res);
    }


}

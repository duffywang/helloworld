package leetcode.Hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * @auther : wangyufei
 * @date : 2022-03-06
 * <p>
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 **/
public class LargestRectangleArea84 {

    /*
     * 暴力求解，大的数据会超出时间限制
     * */
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int max = 0;
        if (len == 0) return max;

        for (int i = 0; i < len; i++) {
            int height = heights[i], w = 1, j = i;
            //每一个节点向外扩张，向右扩张
            while (--j >= 0 && heights[j] >= height) {
                w++;
            }
            //回到中心节点
            j = i;
            //向左扩张
            while (++j < len && heights[j] >= height) {
                w++;
            }
            max = Math.max(max, w * height);

        }
        return max;
    }


    /*
     * 接水滴
     * */
    public static int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }

    public static int largestRectangleArea3(int[] heights) {
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
        int[] array = {6, 7, 5, 2, 4, 5, 9, 3};
        System.out.println(largestRectangleArea3(array));
    }
}

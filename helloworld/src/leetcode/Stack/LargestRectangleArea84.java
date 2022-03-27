package leetcode.Stack;

/**
 * @auther : wangyufei
 * @date : 2021-04-18
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 **/
public class LargestRectangleArea84 {
    //暴力解法，内外循环，一个点向两边扩散，遇到比自己矮的停止
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int mid = 0; mid < heights.length; mid++) {
            int height = heights[mid];
            int left = mid, right = mid;
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                left--;
            }
            while (right + 1 < heights.length && heights[right + 1] >= height) {
                right++;
            }
            res = Math.max(res, (right - left + 1) * height);

        }
        return res;
    }
}

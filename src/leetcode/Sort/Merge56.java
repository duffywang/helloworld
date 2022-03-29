package leetcode.Sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2021-06-09
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 **/
public class Merge56 {
    public static int[][] merge(int[][] intervals) {

        //1.对数组第一个元素排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        //2.放入int[],多个int[] 构成了int[][]
        ArrayList<int[]> list = new ArrayList<>();
        int left = 0, right = 0;
        while (right < intervals.length) {
            //3.记录边界，因为已经排序，左边界在外层是不变的
            int leftBound = intervals[left][0];
            int rightBound = intervals[right][1];
            //4.不断更新最大的右边界
            while (right < intervals.length && intervals[right][0] <= rightBound) {
                rightBound = Math.max(rightBound, intervals[right][1]);
                right++;
            }
            list.add(new int[]{leftBound, rightBound});
            left = right;
        }

        //5.将list转化为int[][] 类型
        int size = list.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] array = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};
        int[][] array2 = {{2, 6}, {6, 8}};
        int[][] array3 = {{2, 6}, {3, 4}};
        int[][] array4 = {{1, 10}, {3, 4}, {5, 6}};
        int[][] res = merge(array);
        System.out.println(res);

    }

}

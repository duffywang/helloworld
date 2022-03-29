package leetcode.Sort;

import java.util.ArrayList;

/**
 * @auther : wangyufei
 * @date : 2021-06-11
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 **/
public class Insert57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int length = intervals.length;
        int i = 0;

        //newInterval左边
        while (i < length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        //newInterval中间重合
        while (i < length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        //可解决intervals为空的问题
        list.add(newInterval);

        //newInterval右边
        while (i < length) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[0][]);


    }

    public static void main(String[] args) {
        int[][] array = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 14}};
        int[] newInterval = {4, 8};
        int[][] res = insert(array, newInterval);
        for (int[] re : res) {
            System.out.println(re[0] + ", " + re[1]);
        }
    }
}

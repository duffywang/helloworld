package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @auther : wangyufei
 * @date : 2020-08-30
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 1 可以认为区间的终点总是大于它的起点。
 * 2 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ] -> [[1,2], [2,3], [1,3], [3,4], ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class OverlapIntervals435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int first_end = intervals[0][1];
        int count = 0;
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start < first_end) {
                count++;
                first_end = interval[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int res = eraseOverlapIntervals(array);
        System.out.println(res);
    }
}

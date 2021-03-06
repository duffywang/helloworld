package leetcode.LeftRightPoint;

import java.util.ArrayList;

/**
 * @auther : wangyufei
 * @date : 2020-09-29
 * 给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 * <p>
 * 返回这两个区间列表的交集。
 * <p>
 * （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。
 * 两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 * <p>
 * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class IntervalIntersection986 {
    public static int[][] intervalIntersection(int[][] A, int[][] B) {

        ArrayList<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {

            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) {
                res.add(new int[]{lo, hi});
            }

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}

package leetcode;

import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2020-08-30
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。
 * <p>
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FindMinArrowShots452 {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
        int count = 1;
        int first_end = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            //等于可以一箭双雕
            if (start > first_end) {
                count++;
                first_end = point[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] array = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int res = findMinArrowShots(array);
        System.out.println(res);
    }
}

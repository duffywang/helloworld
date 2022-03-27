package leetcode.dp;

/**
 * @auther : wangyufei
 * @date : 2021-07-25
 * <p>
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * <p>
 * <p>
 * (value[i] + i) + (value[j] - j)
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxScoreSightseeingPair1014 {
    public static int maxScoreSightseeingPair(int[] values) {
        if (values.length == 2) return values[0] + values[1] - 1;
        int ans = 0;
        int max = values[0] + 0;
        for (int i = 1; i < values.length; i++) {
            //values[i] - i 为 上面的value[j] - j
            ans = Math.max(ans, max + values[i] - i);
            //values[i] + i
            max = Math.max(max, values[i] + i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] values = {8,1,5,2,6};
        int res = maxScoreSightseeingPair(values);
        System.out.println(res);
    }
}

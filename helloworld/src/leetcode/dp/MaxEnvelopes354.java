package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @auther : wangyufei
 * @date : 2020-10-06
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 宽度按升序，如果宽度相等高度按降序排列，排序后不用关注宽度问题只用找高度递增元素个数即可 ，LIS问题
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxEnvelopes354 {
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len == 0 || len == 1) return len;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        int[] height = new int[len];
        for (int i = 0; i < len; i++) {
            height[i] = envelopes[i][1];
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int maxAns = 0;
        for (int i = 1; i < len; i++) {
            int maxValue = 0;
            for (int j = 0; j < i; j++) {
                if (height[j] < height[i]) {
                    maxValue = Math.max(maxValue, dp[j]);
                }
            }
            dp[i] = maxValue + 1;
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}

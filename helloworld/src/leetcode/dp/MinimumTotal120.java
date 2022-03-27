package leetcode.dp;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2021-05-23
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MinimumTotal120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int res = Integer.MAX_VALUE;
        if (n == 0) return 0;
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            m = triangle.get(i).size() > m ? triangle.get(i).size() : m;
        }
        if (n == 1 && m == 1) return triangle.get(0).get(0);
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        List<Integer> first = triangle.get(0);
        for (int i = 0; i < first.size(); i++) {
            dp[0][i] = first.get(i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else {
                    //j = triangle.get(i).size() - 1 的情况不会选择Integer.MAX_VALUE
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        //找到底层中最小的值作为结果返回
        for (int i = 0; i < m; i++) {
            if (dp[n - 1][i] < res) res = dp[n - 1][i];
        }
        return res;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }

    public static int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list1 = Lists.newArrayList(-1);
        ArrayList<Integer> list2 = Lists.newArrayList(-2, -3);
        ArrayList<Integer> list3 = Lists.newArrayList(2, 3, 4);

        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        int res = minimumTotal3(lists);
        System.out.println(res);

        String str = "http://10.72.146.60:80/shop/H2TpRKlamNUGXo12?msource=adunionnoapp&dpLaunchId=26603000&keywordId=257954264132&hideNav=1&productid=74&utm_medium=null&entityid=16312895&pagenum={pagenum}&adposition={adposition}&creative=49198283592&utm=utm_source%3Anull%2Cutm_medium%3Anull&entitytype=1&entityplat=1&unitId=5767336851&hideapp=1&lbs=true&lane=0&utm_source=null&_fb_=ad_cj%3DZ24Dxrhhvm4j4yemAHWAXKv3qMvEZf90QhtMh4gW11rrR_3MWhZdgRiNr4ZDTDk8LOjdkbiZBaLbOhngSJppQ76Gxikj1kuoT1jIwp54oOe6IWVCh5wgeTN5ZqWCzNwgunFzjWJgNjI4%26sver%3D2%26ad_v%3D1%26ad_ci%3DZ24DxrhzYtJz5aChRdy9AqJt690jK_ZwqVHxKOx6lzJKs-IV0NeeTI7tOitVoOd5vfqNOdNmWa4FfN8Q0pGUjwpdt_n0fPIY%26adunion_source%3Dh5%3Adianping%3Apoi%26keywordid%3D257954264132%26request_id%3D1398247862408262753";
        System.out.println(str.charAt(174));
        System.out.println(str.charAt(175));
        System.out.println(str.charAt(176));
        System.out.println(str.charAt(177));
        System.out.println(str.charAt(178));
        System.out.println(str.charAt(179));
        System.out.println(str.charAt(180));
    }
}

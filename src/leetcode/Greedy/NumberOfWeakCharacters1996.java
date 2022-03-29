package leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @auther : wangyufei
 * @date : 2022-01-29
 * <p>
 * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
 * <p>
 * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
 * <p>
 * 返回 弱角色 的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NumberOfWeakCharacters1996 {
    public static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] == o1[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        int res = 0;
        int maxDenfence = -1;
        int n = properties.length;
        for (int i = 0; i < n; i++) {
            if (maxDenfence > properties[i][1]) {
                res++;
            }
            maxDenfence = Math.max(maxDenfence, properties[i][1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2}, {2, 1}, {2, 2}, {1, 1}};
        System.out.println(numberOfWeakCharacters(array));
    }
}

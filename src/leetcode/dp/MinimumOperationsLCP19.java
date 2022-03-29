package leetcode.dp;

/**
 * @auther : wangyufei
 * @date : 2022-03-26
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 * <p>
 * 输入：leaves = "rrryyyrryyyrr"
 * <p>
 * 输出：2
 * <p>
 * 输入：leaves = "ryr"
 * <p>
 * 输出：0
 * <p>
 * 解释：已符合要求，不需要额外操作
 * <p>
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/UlBDOe
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MinimumOperationsLCP19 {
    public int minimumOperations(String leaves) {
        int n = leaves.length(), cnt = 0, ans = 0;
        if (leaves.charAt(0) == 'y') ++ans;
        if (leaves.charAt(n - 1) == 'y') ++ans;
        for (int i = 1; i < n - 1; i++) {
            if (leaves.charAt(i) == 'y') ++cnt;
        }
        //中间全是rr,
        if (cnt == 0) return 1 + ans;
        //
        int cur = 0, mx = 0;
        for (int i = 1; i < n - 1; i++) {
            char c = leaves.charAt(i);
            if (c == 'y') {
                ++cur;
            } else {
                //c == 'r'
                if (cur > 0) {
                    cur--;
                }
            }
            mx = Math.max(cur, mx);
        }
        //中间y个数 - 选择变y还是变r + 两头变r个数
        return cnt - mx + ans;
    }
}

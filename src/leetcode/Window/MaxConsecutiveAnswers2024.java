package helloworld.src.leetcode.Window;

/**
 * @auther : wangyufei
 * @date : 2022-03-29
 * <p>
 * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 * <p>
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 * <p>
 * 输入：answerKey = "TTFF", k = 2
 * 输出：4
 * 解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
 * 总共有四个连续的 'T' 。
 * <p>
 * 输入：answerKey = "TTFTTFTT", k = 1
 * 输出：5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxConsecutiveAnswers2024 {
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getMaxConsecutiveAnswers(answerKey, k, 'T'), getMaxConsecutiveAnswers(answerKey, k, 'F'));
    }

    private static int getMaxConsecutiveAnswers(String answerKey, int k, Character s) {
        int len = answerKey.length();
        int left = 0, right = 0, sum = 0, res = 0;
        for ( ; right < len; right++) {
            //每用一次机会加1
            sum += answerKey.charAt(right) != s ? 1 : 0;
            while (sum > k) {
                sum -= answerKey.charAt(left++) != s ? 1 : 0;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = maxConsecutiveAnswers("TTFTTFTTT", 1);
        System.out.println(res);
    }
}

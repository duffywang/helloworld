package leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2021-07-25
 * <p>
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 * <p>
 * 输入：S = "12345"
 * 输出：["12345"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LetterCasePermutation784 {
    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s.toCharArray(), "");
        return res;

    }

    private static void helper(List<String> res, char[] chars, String pos) {
        for (int i = pos.length(); i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                char another = (char) (chars[i] - 'a' >= 0 ? chars[i] - 32 : chars[i] + 32);
                helper(res, chars, pos + another);
            }
            pos = pos + chars[i];
        }
        res.add(pos);

    }

    public static void main(String[] args) {
        String s = "u1s1";
        letterCasePermutation(s);
    }
}

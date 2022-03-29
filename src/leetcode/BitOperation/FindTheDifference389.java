package leetcode.BitOperation;

/**
 * @auther : wangyufei
 * @date : 2021-06-05
 * <p>
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 **/
public class FindTheDifference389 {
    public static char findTheDifference(String s, String t) {
        int ls = s.length();
        int sums = 0, sumt = 0;
        int lt = t.length();

        for (int i = 0; i < ls; i++) {
            sums += s.charAt(i) - 'a';
        }
        for (int i = 0; i < lt; i++) {
            sumt += t.charAt(i) - 'a';
        }
        return (char) (sumt - sums + 'a');
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        char res = findTheDifference(s, t);
        System.out.println(res);
    }
}

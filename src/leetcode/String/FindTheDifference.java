package leetcode.String;

/**
 * @auther : wangyufei
 * @date : 2022-01-23
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
public class FindTheDifference {
    public static char findTheDifference(String s, String t) {

        //用int[]而不是char[]
        int[] dic = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            dic[index]++;
        }
        int j = 0;
        for (; j < t.length(); j++) {
            int index = t.charAt(j) - 'a';
            dic[index]--;
            if (dic[index] < 0) break;
        }
        return t.charAt(j);

    }

    /*和两个数字中找不同类似，用位运算*/
    public static char findTheDifference2(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        char res = 0;
        int i = 0;
        for (; i < cs.length; res ^= cs[i], res ^= ts[i], i++) ;
        res ^= ts[i];
        return res;
    }


    public static void main(String[] args) {
        System.out.println(findTheDifference2("abcd", "abcde"));
    }


}

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther : wangyufei
 * @date : 2020-10-08
 * <p>
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 **/
public class LongestPalindrome409 {
    public static int longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int odd = 0, even = 0, count = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                even += entry.getValue();
            } else {
                odd += entry.getValue();
                count++;
            }
        }
        int sum = even + odd;
        return count > 0 ? sum - count + 1 : sum;

    }

    public static void main(String[] args) {
        int res = longestPalindrome("abccccdd");
        System.out.println(res);
    }
}

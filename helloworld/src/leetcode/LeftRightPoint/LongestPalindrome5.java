package leetcode.LeftRightPoint;

/**
 * @auther : wangyufei
 * @date : 2020-10-08
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 **/
public class LongestPalindrome5 {
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String res1 = palindrome(s, i, i);
            String res2 = palindrome(s, i, i + 1);
            res = res.length() > res1.length() ? res : res1;
            res = res.length() > res2.length() ? res : res2;
        }
        return res;
    }

    public static String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String str = "abcbc";
        String res = longestPalindrome(str);
        System.out.println(res);
    }
}

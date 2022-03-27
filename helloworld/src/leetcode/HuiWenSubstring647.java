package leetcode;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * input:abc
 * output:3
 * <p>
 * input:aaa
 * output:6 (a a a aa aa aaa)
 *
 * @auther : wangyufei
 * @date : 2020-02-04
 **/
public class HuiWenSubstring647 {
    public static void main(String[] args) {
        String input = "aabbaa";
        HuiWenSubstring647 object = new HuiWenSubstring647();
        int res = object.countSubstrings2(input);
        System.out.println(res);

    }

    public static int countSubstrings(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (isHuiwen(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isHuiwen(String str) {
        int len = str.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }

    int sum = 0;

    //从中间向两边扩张
    public int countSubstrings2(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);//奇数情况满足条件
            count(s, i, i + 1);//偶数情况满足条件
        }
        return sum;

    }

    private void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            sum++;
            start--;
            end++;
        }
    }

}

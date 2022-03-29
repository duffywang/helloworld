package leetcode.LeftRightPoint;

/**
 * @auther : wangyufei
 * @date : 2021-07-14
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * TODO : 录入博客
 **/
public class ReverseWords557 {
    public static String reverseWords(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < len) {
            int start = i;
            while (i < len && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                sb.append(s.charAt(i - 1 - p + start));
            }
            while (i < len && s.charAt(i) == ' ') {
                i++;
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = reverseWords("Let's take LeetCode contest");
        System.out.println(res);
    }

}

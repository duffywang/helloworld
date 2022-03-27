package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-08-19
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 *
 * 注意：正则表达式\s表示匹配任何空白字符，+表示匹配一次或多次。 " "只能匹配一个空格
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ReverseWords58 {
    public static String reverseWords(String s) {
        String[] array = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int len = array.length;
        for (int i = len - 1; i >= 0; i--) {
            sb.append(array[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = " the  sky is  blue";
        String res = reverseWords(input);
        System.out.println(res);
    }

}

package leetcode.Stack;

import java.util.Stack;

/**
 * @auther : wangyufei
 * @date : 2021-06-06
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * <p>
 * PS：龙俊出题
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class DecodeString394 {


    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int multi = 0;
        Stack<Integer> stackMulti = new Stack<>();
        Stack<String> stackRes = new Stack<>();
        for (char c : s.toCharArray()) {
            //前面肯定右数字
            if (c == '[') {
                //记录重复的次数，在遇到']'时弹出
                stackMulti.push(multi);
                //已有结果放入结果栈中
                stackRes.add(sb.toString());
                //初始化
                multi = 0;
                sb = new StringBuilder();
                //说明前面肯定有[
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                Integer curMulti = stackMulti.pop();
                for (int i = 0; i < curMulti; i++) {
                    tmp.append(sb);
                }
                //现在结果为之前的结果和循环后的拼接
                sb = new StringBuilder(stackRes.pop() + tmp);
            } else if (Character.isDigit(c)) {
                //注意数字不一定是个位数
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();


    }

    public static void main(String[] args) {
        //String str = "3[a]2[bc]";
        String str2 = "31[a2[c]]";
        String res2 = decodeString(str2);

    }
}

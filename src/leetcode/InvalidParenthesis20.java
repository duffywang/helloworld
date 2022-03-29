package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @auther : wangyufei
 * @date : 2020-07-12
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 **/
public class InvalidParenthesis20 {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack();
        HashMap<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty() || !map.get(c).equals(stack.pop())) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("()" + isValid("()"));
        System.out.println("([])" + isValid("([])"));
        System.out.println("(][)" + isValid("(][)"));
        System.out.println("()[]{}" + isValid("()[]{}"));
    }


}

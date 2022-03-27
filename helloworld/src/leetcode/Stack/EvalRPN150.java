package leetcode.Stack;

import java.util.HashSet;
import java.util.Stack;

/**
 * @auther : wangyufei
 * @date : 2021-06-06
 * <p>
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 **/
public class EvalRPN150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> resStack = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (String token : tokens) {
            if (set.contains(token)) {
                Integer end = resStack.pop();
                Integer start = resStack.pop();
                resStack.push(operation(start, end, token));
            } else {
                resStack.push(Integer.parseInt(token));
            }
        }
        return resStack.pop();
    }

    private static Integer operation(Integer start, Integer end, String token) {
        if ("+".equals(token)) {
            return start + end;
        } else if ("-".equals(token)) {
            return start - end;
        } else if ("*".equals(token)) {
            return start * end;
        } else {
            return start / end;
        }
    }

    public static void main(String[] args) {
        String[] array = {"2", "1", "+", "3", "*"};
        String[] array2 = {"4","13","5","/","+"};
        int res = evalRPN(array2);
        System.out.println(res);
    }
}

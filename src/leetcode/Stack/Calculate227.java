package leetcode.Stack;

import java.util.Stack;

/**
 * @auther : wangyufei
 * @date : 2022-02-10
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 **/
public class Calculate227 {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        int sum = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //可能是多位数，如15
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            //到最后一位的时候，无论是什么，要把之前还有的操作符使用完
            if ((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                sign = c;
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;

    }

    public static void main(String[] args) {
        System.out.println(calculate(" 3+1 5 / 2 + 2*9"));
    }
}

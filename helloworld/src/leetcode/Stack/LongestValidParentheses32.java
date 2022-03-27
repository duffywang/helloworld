package leetcode.Stack;

import java.util.Stack;

/**
 * @auther : wangyufei
 * @date : 2022-03-13
 * <p>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * <p>
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 **/
public class LongestValidParentheses32 {

    /*Stack */
    public static int longestValidParentheses(String s) {
        int length = s.length();
        if (length == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        //防止第一次stack为空时pop
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    /*
     * 左右指针left 、right 从左往右遍历，遇到(left++,遇到 ) right++，当left==right时，计算当前有效字符串的长度，当right计数器比left大时，left和right计数器同时变回0
     * 可以解决())的情况，但是无法解决(()的情况，因此需要从有到左再遍历一次
     * */
    public static int longestValidParentheses2(String s) {
        int length = s.length();
        int left = 0, right = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (left > right) {
                left = right = 0;
            }

        }
        return max;
    }

    /*动态规划
    * d[i]以i开头的最长有效括号*/
    public static int longestValidParentheses3(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        int res = 0;
        for (int i = len - 2; i >= 0 ; i--) {
            if (s.charAt(i) == '('
                    && i + dp[i+1] + 1 < len
                    && s.charAt(i) != s.charAt(i + dp[i+1] + 1)){
                dp[i] = dp[i+1] + 2 + dp[i + dp[i+1] + 2];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }



        public static void main(String[] args) {
        String str = "((())))";
        System.out.println(longestValidParentheses(str));
    }
}

package leetcode.LeftRightPoint;

import java.util.HashMap;

/**
 * @auther : wangyufei
 * @date : 2020-09-22
 * <p>
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 **/
public class MinWindow76 {
    public static String minWindow(String s, String t) {
        int left = 0, right = 0, start = 0;
        int match = 0;
        String res = "";
        int min = Integer.MAX_VALUE;
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char c : chars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    match++;
                }
            }
            right++;

            while (need.size() == match) {
                if (right - left < min) {
                    res = s.substring(left, right);
                    min = right - left;
                }

                char l = s.charAt(left);
                if (need.containsKey(l)) {
                    window.put(l, window.get(l) - 1);
                    if (window.get(l) < (need.get(l))) {
                        match--;
                    }
                }
                left++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow(s, t);
        System.out.println(res);
    }
}

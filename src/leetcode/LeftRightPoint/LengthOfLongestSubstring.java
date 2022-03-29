package leetcode.LeftRightPoint;

import java.util.HashMap;

/**
 * @auther : wangyufei
 * @date : 2020-09-22
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 模板总结：
 * 左右指针和HashMap
 * <p>
 * int left = 0, right = 0;
 * <p>
 * while (right < s.size()) {
 * window.add(s[right]);
 * right++;
 * <p>
 * while (valid) {
 * window.remove(s[left]);
 * left++;
 * }
 * }
 **/
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            right++;
            while (map.get(c) > 1) {
                char z = s.charAt(left);
                map.put(z, map.getOrDefault(z, 0) - 1);
                left++;
            }
            max = Math.max(max, right - left);

        }
        return max;

    }

}

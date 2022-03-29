package swordoffer;

import java.util.HashMap;

/**
 * @auther : wangyufei
 * @date : 2020-08-23
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 输入: "abcabcbb" "bbbbb"  ""
 * 输出: 3            1      0
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 **/
public class LengthOfLongestSubstring48 {
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        // 需要开128 数组空间，不够灵活
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            //char 对应的index 转换为int 类型，如a对应的是97
            int index = s.charAt(i);
            //+1为不包括左窗
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }


    /**
     * 双指针方法
     * i(头指针) 指针探路，如果遇到有重复出现的元素，则让j(尾指针)更新，但也不一定更新，因为可能j比这个重复的元素所在索引更大
     **/
    public static int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        int max = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                j = Math.max(j, charMap.get(s.charAt(i)) + 1);
            }
            charMap.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    /**
     * 滑动窗口解法
     * 使用位图相比上面用hashMap 耗时更优
     */
    public static int lengthOfLongestSubstring2(String s) {
        int max = 0, len = s.length(), left = 0, right = 0;
        int[] array = new int[123];

        while (right < len) {
            if (++array[s.charAt(right) - ' '] > 1) {
                while (array[s.charAt(right) - ' '] > 1) {
                    --array[s.charAt(left) - ' '];
                    left++;
                }
                right++;
            } else {
                right++;
                max = Math.max(max, right - left);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String str = "abcabcbb";
        int res = lengthOfLongestSubstring2(str);
        System.out.println(res);
    }
}

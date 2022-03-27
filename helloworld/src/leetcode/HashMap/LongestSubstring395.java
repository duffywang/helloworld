package leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther : wangyufei
 * @date : 2022-02-27
 * <p>
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * <p>
 * 输入：s = "aaabbbc", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 **/
public class LongestSubstring395 {

    public static int longestSubstring(String s, int k) {
        int res = 0;
        int len = s.length();
        for (int i = 1; i <= 9; i++) {
            int l = 0, r = 0;
            //滑动窗口内部每个字符出现的次数
            int[] cnt = new int[26];
            //滑动窗口内字符种类，当前出现次数小于k的字符的数量
            int tot = 0, less = 0;
            while (r < len) {
                int indexR = s.charAt(r) - 'a';
                int indexL = s.charAt(l) - 'a';
                cnt[indexR]++;
                if (cnt[indexR] == 1) {
                    tot++;
                    less++;
                }
                if (cnt[indexR] == k) {
                    less--;
                }
                //
                while (tot > i) {
                    cnt[indexL]--;
                    if (cnt[indexL] == k - 1) {
                        less++;
                    }
                    if (cnt[indexL] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }

                if (less == 0) {
                    res = Math.max(res, r - l + 1);
                }

                r++;

            }

        }
        return res;

    }


    public static void main(String[] args) {
        System.out.println(longestSubstring("bchhbbdefghiaaacb",3));
    }
}

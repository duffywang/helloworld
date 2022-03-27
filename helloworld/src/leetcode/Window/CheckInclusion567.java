package leetcode.Window;

import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2021-07-17
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 **/
public class CheckInclusion567 {
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            /**
             * 滑动窗口，窗口大小为n
             * 用位图来表示各个字符出现的次数，不用列出s1中所有的全排列
             * */
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            /**
             * 判断两个数组相同
             * */
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "casdfabsrqkof";
        checkInclusion(s1, s2);

    }

}

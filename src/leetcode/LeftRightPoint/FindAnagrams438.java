package leetcode.LeftRightPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-09-22
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FindAnagrams438 {
    public static List<Integer> findAnagrams(String s, String p) {
        int left = 0, right = 0;
        int match = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        char[] chars = p.toCharArray();
        for (char c : chars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (right < s.length()) {

            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 只用在乎滑动窗中包含了need中某一元素所需的个数，说明这个元素就是符合
                if (window.get(c).equals(need.get(c))) {
                    match++;
                }
            }
            right++;
            // need.size() 和 match 时说明
            while (match == need.size()) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                char l = s.charAt(left);
                if (need.containsKey(l)) {
                    window.put(l, window.get(l) - 1);
                    // 可能有多个只是减少一个，还无法完全匹配这个元素
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
        String s = "aebfc";
        String p = "abc";
        List<Integer> res = findAnagrams(s, p);


    }
}

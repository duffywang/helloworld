package src.coder;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther : wangyufei
 * @date : 2020-09-05
 * <p>
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 **/
public class CheckPermutation {
    public boolean checkPermutation(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;

    }
}

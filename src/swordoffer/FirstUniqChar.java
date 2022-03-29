package src.swordoffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther : wangyufei
 * @date : 2020-07-19
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 **/
public class FirstUniqChar {
    public static char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        LinkedHashMap<Character, Boolean> linkedHashMap = new LinkedHashMap<>();
        for (char c : chars) {
            //通过
            map.put(c, !map.containsKey(c));
            linkedHashMap.put(c, !linkedHashMap.containsKey(c));
        }
        //注意不要遍历HashMap,如果使用要使用LinkedHashMap
//        for (char c : chars) {
//            if (map.get(c)) return c;
//        }
        for (Map.Entry<Character, Boolean> entry : linkedHashMap.entrySet()) {
            if (entry.getValue()) return entry.getKey();
        }
        return ' ';
    }

    public static void main(String[] args) {
        char res = firstUniqChar("abaccdeff");
        System.out.println(res);
    }
}

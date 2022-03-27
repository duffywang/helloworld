package leetcode.String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @auther : wangyufei
 * @date : 2022-02-27
 * <p>
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * <p>
 * 输入: s = "loveleetcode"
 * 输出: 2
 **/
public class FirstUniqChar387 {
    public static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            if (!map2.containsKey(array[i])) {
                map2.put(array[i], i);
            }
        }


        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return map2.get(entry.getKey());
            }
        }
        return -1;

    }

    public static int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>(26);
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }




        public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}

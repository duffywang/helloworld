package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @auther : wangyufei
 * @date : 2020-08-31
 **/
public class HashMapCompute {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] array = new String[]{"we", "word", "we", "world"};
        Arrays.asList(array).forEach(word -> {
            map.putIfAbsent(word, 0);
            map.compute(word, (w, count) -> count + 1);
        });
    }
}

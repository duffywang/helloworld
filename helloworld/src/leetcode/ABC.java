package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-02-08
 **/
public class ABC {
    public static void main(String[] args) {
        List<String> blocks = Arrays.asList(
                "BO", "XK", "DQ", "CP", "NA",
                "GT", "RE", "TG", "QD", "FS",
                "JW", "HU", "VI", "AN", "OB",
                "ER", "FS", "LY", "PC", "ZM");
        List<String> list = Arrays.asList("", "A", "BARK", "BOOK", "COMMON", "CONFUSE", "FUSS", "SQUAD");
        for (String s : list) {
            System.out.printf("%s: %s%n", s.isEmpty() ? "\"\"" : s, canMakeWord(s, blocks));
        }
    }

    public static boolean canMakeWord(String word, List<String> blocks) {
        if (word.isEmpty()) return true;

        char c = word.charAt(0);
        for (int i = 0; i < blocks.size(); i++) {
            String block = blocks.get(i);
            if (block.charAt(0) != c && block.charAt(1) != c) continue;
            Collections.swap(blocks, 0, i);
            if (canMakeWord(word.substring(1), blocks.subList(1, blocks.size()))) {
                return true;
            }
            Collections.swap(blocks, 0, i);
        }
        return false;

    }

}

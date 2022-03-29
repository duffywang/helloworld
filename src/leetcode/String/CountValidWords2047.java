package leetcode.String;

/**
 * @auther : wangyufei
 * @date : 2022-01-27
 * 句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。每个句子可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。
 * <p>
 * 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
 * <p>
 * 仅由小写字母、连字符和/或标点（不含数字）。
 * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
 * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
 * 这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。
 * <p>
 * 给你一个字符串 sentence ，请你找出并返回 sentence 中 有效单词的数目 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CountValidWords2047 {
    public static int countValidWords(String sentence) {
        String[] split = sentence.split(" ");
        int res = 0;

        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            char[] array = s.toCharArray();
            int one = 0;
            for (int j = 0; j < array.length; j++) {
                if (isNumberChar(array[j])) break;
                if (!isValidChar(array[j])) {
                    if (j != array.length - 1 && isSybomChar(array[j])) break;
                    if (isOnesChar(array[j])) {
                        one++;
                        if (one == 1 && j > 0 && j < array.length - 1 && isValidChar(array[j - 1]) && isValidChar(array[j + 1])) {
                            continue;
                        } else {
                            break;
                        }
                    }
                }
                if (j == array.length - 1 && isValidChar(array[j])) res++;
                if (j == array.length - 1 && isSybomChar(array[j])) res++;
            }
        }

        return res;
    }

    private static boolean isNumberChar(char c) {
        return c - '0' >= 0 && '9' - c >= 0;
    }

    private static boolean isValidChar(char c) {
        return c - 'a' >= 0 && 'z' - c >= 0;
    }

    private static boolean isSybomChar(char c) {
        return c - '!' == 0 || c - '.' == 0 || c - ',' == 0;
    }

    private static boolean isOnesChar(char c) {
        return c - '-' == 0;
    }


    public static void main(String[] args) {
        String sentence = "!this  1-s b8d!";
        System.out.println(countValidWords(sentence));

    }
}

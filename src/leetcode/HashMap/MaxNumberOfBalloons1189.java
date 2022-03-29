package leetcode.HashMap;

import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2022-02-13
 * <p>
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxNumberOfBalloons1189 {
    public static int maxNumberOfBalloons(String text) {
        int[] array = new int[5];
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (c == 'b') {
                array[0]++;
            } else if (c == 'a') {
                array[1]++;
            } else if (c == 'n') {
                array[2]++;
            } else if (c == 'l') {
                array[3]++;
            } else if (c == 'o') {
                array[4]++;
            }
        }
        array[3] /= 2;
        array[4] /= 2;
        //很方便，如果用Math.min(x,y)每次只能比较两个值，需要比较很多次
        return Arrays.stream(array).min().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }


}

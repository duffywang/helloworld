package leetcode.LeftRightPoint;

/**
 * @auther : wangyufei
 * @date : 2020-10-06
 * <p>
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 输入:
 * s = "ABAB", k = 2
 * <p>
 * 输出:
 * 4
 * <p>
 * 解释:
 * 用两个'A'替换为两个'B',反之亦然。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CharacterReplacement424 {
    public static int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int left = 0, right = 0, maxWindow = 0;
        int len = s.length();
        char[] array = s.toCharArray();
        for (; right < len; right++) {
            int index = array[right] - 'A';
            map[index]++;
            maxWindow = Math.max(maxWindow, map[index]);//比较之前记录最大值和当前字符数量
            if (right - left + 1 - maxWindow > k) {//是否超过k个替换
                map[array[left] - 'A']--;//将窗口最左边字符在计数数组中减一
                left++;//左滑动窗
            }
        }
        return len - left;
    }

    public static void main(String[] args) {
        String input = "AABABBA";
        int res = characterReplacement(input, 1);
        System.out.println(res);
    }
}

package leetcode.String;

/**
 * @auther : wangyufei
 * @date : 2022-01-05
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * <p>
 * 注意：你 不能 修改非 '?' 字符。
 * <p>
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ModifyString1576 {
    public static String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '?') {
                char a = 'a';
                while ((i > 0 && chars[i - 1] == a) || i < chars.length - 1 && chars[i + 1] == a) {
                    a++;
                }
                chars[i] = a;
            }

        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(modifyString("asdb?aasd"));
    }
}

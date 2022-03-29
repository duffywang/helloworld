package leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @auther : wangyufei
 * @date : 2022-03-17
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class RestoreIpAddresses93 {
    public static List<String> restoreIpAddresses(String s) {
        int length = s.length();
        ArrayList<String> res = new ArrayList<>();

        if (length < 4 || length > 12) return res;
        Stack<String> stack = new Stack<>();
        int splitTimes = 0;
        helper(s, length, splitTimes, 0, stack, res);
        return res;
    }

    private static void helper(String s, int length, int splitTimes, int begin, Stack<String> stack, ArrayList<String> res) {
        if (begin == length) {
            if (splitTimes == 4) {
                res.add(String.join(".", stack));
            }
            return;
        }

        // 剩下的不够了
        if (length - begin < (4 - splitTimes) || length - begin > 3 * (4 - splitTimes)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (begin + i >= length) {
                break;
            }

            int ipSegment = judgeIfIpSegment(s, begin, begin + i);
            if (ipSegment != -1) {
                stack.push(ipSegment + "");
                helper(s, length, splitTimes + 1, begin + i + 1, stack, res);
                stack.pop();
            }

        }

    }

    private static int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        //0后面必须为0，不能有01这种
        if (len > 1 && s.charAt(left) == '0') return -1;
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        //不能大于255
        if (res > 255) return -1;
        return res;
    }

    public static void main(String[] args) {
        List<String> res = restoreIpAddresses2("25525511135");
        for (String re : res) {
            System.out.println(re);
        }
    }

    //暴躁老哥
    public static List<String> restoreIpAddresses2(String s) {
        int len = s.length();
        ArrayList<String> res = new ArrayList<>();
        if (len < 4 || len > 12) return res;
        for (int i = 1; i <= len - 3; i++) {
            if (i > 3) break;
            for (int j = i + 1; j <= len - 2; j++) {
                if (j > 6) break;
                for (int k = j + 1; k <= len - 1; k++) {
                    if (k > 9) break;
                    String str1 = s.substring(0, i);
                    if (!isValidNum(str1)) continue;
                    String str2 = s.substring(i, j);
                    if (!isValidNum(str2)) continue;
                    String str3 = s.substring(j, k);
                    if (!isValidNum(str3)) continue;
                    String str4 = s.substring(k, len);
                    if (!isValidNum(str4)) continue;
                    res.add(String.join(".", str1, str2, str3, str4));
                }
            }
        }
        return res;
    }

    private static boolean isValidNum(String str) {
        if (str.length() == 0) return false;
        if (str.length() > 1 && str.charAt(0) == '0') return false;
        if (Integer.parseInt(str) > 255) return false;
        return true;
    }


}

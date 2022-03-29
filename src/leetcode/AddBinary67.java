package leetcode;

/**
 * @auther : wangyufei
 * @date : 2021-05-30
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 **/
public class AddBinary67 {

    public static String addBinary2(String a, String b) {
        //先将a和b转化为十进制，求合后再转化为二进制。
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));

    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int carry = 0;

        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            sb.append('1');
        }
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "1011";
        String b = "11001";
        String res = addBinary(a, b);
        System.out.println(res);


    }
}

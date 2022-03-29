package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-07-11
 **/
public class StringsAdd415 {
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (carry > 0 || i >= 0 || j >= 0) {
            //注意 .charAt(inedx) 返回结果为char 需要 - '0'
            if (i >= 0) carry += num1.charAt(i--) - '0';
            if (j >= 0) carry += num2.charAt(j--) - '0';
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String res = addStrings("123445", "456");
        System.out.println(res);
    }


}

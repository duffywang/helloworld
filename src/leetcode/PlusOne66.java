package leetcode;

import java.text.SimpleDateFormat;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * input:[1,2,4]
 * output:[1,2,5]
 *
 * @auther : wangyufei
 * @date : 2020-02-09
 **/
public class PlusOne66 {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] res = plusOne(digits);
        for (int re : res) {
            System.out.println(re);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");


    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                break;
            } else {
                if (i == 0) {
                    digits = new int[len + 1];
                    digits[0] = 1;
                }
            }
        }
        return digits;

    }
}

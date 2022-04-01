package src.leetcode.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2022-03-31
 * <p>
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * <p>
 * 给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。
 * <p>
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CheckPerfectNumber507 {

    public static boolean checkPerfectNumber(int num) {
        List<Integer> list = new ArrayList<>();
        int  sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (isValidNum(i, num)) list.add(i);
        }

        for (Integer i : list) {
            sum += i;
        }
        return sum == num;
    }

    public static boolean checkPerfectNumber2(int num) {
        if (num == 1)return false;
        //避免1加两次
        int sum = 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            //除数和结果一起加上
            if (num % i == 0)sum += (num/i + i);
        }
        return sum == num;
    }


        private static boolean isValidNum(int i, int num) {
        return num % i == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(7));
    }
}

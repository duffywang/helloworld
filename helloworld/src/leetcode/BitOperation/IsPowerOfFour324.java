package leetcode.BitOperation;

/**
 * @auther : wangyufei
 * @date : 2021-06-03
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class IsPowerOfFour324 {
    public static boolean isPowerOfFour(int n) {
        return n ==1 || (n > 0 && (n & (n - 1)) == 0 && getCount(n-1));
    }

    public static boolean getCount(int input) {
        int res = 0;
        while ((input & (input - 1)) > 0) {
            input = (input & (input - 1));
            res++;
        }
        return res % 2 != 0;
    }

    public boolean isPowerOfFour2(int n) {
        return (n > 0) && ((n & (n-1)) == 0) && (n % 3 == 1);
    }



    public static void main(String[] args) {
        System.out.println(isPowerOfFour(2));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(16));
    }
}

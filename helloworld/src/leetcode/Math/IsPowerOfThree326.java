package leetcode.Math;

/**
 * @auther : wangyufei
 * @date : 2022-02-27
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 * 输入：n = 27
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class IsPowerOfThree326 {
    public static boolean isPowerOfThree(int n) {
        if (n  ==  1)return true;
        if (n % 3 != 0 || n <= 0){
            return false;
        }
        return isPowerOfThree(n/3);
    }


    /*
    * 不使用循环和递归
    * 3的19次幂，整数范围内最大的数了
    * */
    public static boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 %n == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }
}

package leetcode.Math;

/**
 * @auther : wangyufei
 * @date : 2022-01-23
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 * <p>
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 给你整数 n ，返回 arr 最后剩下的数字。
 * <p>
 * 输入：n = 9
 * 输出：6
 * 解释：
 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * arr = [2, 4, 6, 8]
 * arr = [2, 6]
 * arr = [6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/elimination-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LastRemaining390 {
    public static int lastRemaining(int n) {
        int first = 1;
        int step = 1;
        boolean left = true;

        while (n > 1) {
            if (left || (n & 1) == 1) {
                //正序或者奇数时会加上step，奇数时消除偶数个，消完还是奇数个
                first += step;
            }
            left = !left;
            step *= 2;
            n = n / 2;
        }
        return first;
    }

    /*1,2,3,4,5,6,7,8,9,10,11,12,13,14
     * 2,4,6,8,10,12,14
     * 4,8,12
     * 8
     *
     * 1 + 1 + 2 + 4？
     * */
    public static void main(String[] args) {
        System.out.println(lastRemaining(14));
    }
}

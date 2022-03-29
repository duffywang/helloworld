package leetcode.Greedy;

/**
 * @auther : wangyufei
 * @date : 2020-10-18
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * <p>
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * <p>
 * 请你计算 最多 能喝到多少瓶酒。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-bottles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NumWaterBottles1518 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int empty = numBottles;
        while (empty >= numExchange) {
            numBottles = numBottles + empty / numExchange;
            empty = empty / numExchange + empty % numExchange;
        }
        return numBottles;
    }

    public static void main(String[] args) {
        int res = numWaterBottles(15, 4);
        System.out.println(res);
    }
}

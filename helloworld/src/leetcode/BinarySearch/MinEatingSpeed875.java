package leetcode.BinarySearch;

/**
 * @auther : wangyufei
 * @date : 2020-10-11
 * <p>
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MinEatingSpeed875 {

    public static int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = getMax(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEating(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canEating(int[] piles, int speed, int h) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile % speed != 0 ? pile / speed + 1 : pile / speed);
        }
        if (sum <= h) return true;
        return false;
    }

    private static int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {30, 11, 23, 4, 20};
        int res = minEatingSpeed(array, 6);
        System.out.println(res);

    }

}

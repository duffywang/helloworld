package leetcode.BinarySearch;

/**
 * @auther : wangyufei
 * @date : 2020-10-11
 * <p>
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * <p>
 * 思路：
 * 对于一艘承载力为K船来说，我们必然会在不超过其承载力的前提下贪心地往上装载货物，这样才能使得运送包裹所花费的时间最短。
 * 如果船在承载力为K的条件下可以完成在D天内送达包裹的任务，那么任何承载力大于K的条件下依然也能完成任务。
 * 我们可以让这个承载力K从
 * max(weights)开始（即所有包裹中质量最大包裹的重量，低于这个重量我们不可能完成任务），逐渐增大承载力K，直到K可以让我们在D天内送达包裹。此时K即为我们所要求的最低承载力。
 * 逐渐增大承载力K的方法效率过低，让我们用二分查找的方法来优化它。
 * <p>
 * 作者：KLEA
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/solution/zai-dtian-nei-song-da-bao-guo-de-neng-li-by-lenn12/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ShipWithinDays1011 {
    public static int shipWithinDays(int[] weights, int D) {
        int left = getMin(weights);
        int right = getSum(weights);

        while (left < right) {
            int mid = left + (right - left) / 2;
            /**
             * 找到一个临界点，使left = right，right是可以完成运送的*/
            if (canShip(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 每天可以晕的最大货为mid
     * 在D天内要运完 i == len
     */
    private static boolean canShip(int[] weights, int mid, int D) {
        int i = 0;
        int len = weights.length;
        for (int d = 0; d < D; d++) {
            int maxShip = mid;
            while ((maxShip -= weights[i]) >= 0) {
                i++;
                if (i == len) {
                    return true;
                }
            }
        }
        return false;

    }

    private static int getSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }

    private static int getMin(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int weight : weights) {
            if (weight > max) max = weight;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int res = shipWithinDays(array, 5);
        System.out.println(res);
    }
}

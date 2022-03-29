package leetcode.Greedy;

import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2020-10-18
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Candy135 {
    public static int candy(int[] ratings) {
        int len = ratings.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);
        if (len <= 1) return len;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) res[i] = res[i - 1] + 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) res[i] = Math.max(res[i], res[i + 1] + 1);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += res[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 2};
        int res = candy(array);
        System.out.println(res);
    }
}

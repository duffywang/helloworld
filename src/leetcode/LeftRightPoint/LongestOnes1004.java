package leetcode.LeftRightPoint;

/**
 * @auther : wangyufei
 * @date : 2020-10-06
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LongestOnes1004 {
    public static int longestOnes(int[] A, int K) {
        int left = 0, right = 0;
        int count = 0, res = 0;
        int len = A.length;
        while (right < len) {

            if (A[right++] == 0) {
                count++;
            }
            if (count > K) {
                if (A[left++] == 0) {
                    count--;
                }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int res = longestOnes(array, 3);
        System.out.println(res);
    }
}

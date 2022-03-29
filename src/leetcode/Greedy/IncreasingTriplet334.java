package leetcode.Greedy;

/**
 * @auther : wangyufei
 * @date : 2022-02-11
 * <p>
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * <p>
 * 输入：nums = [2,1,5,0,4,6] -> [-1, 4, -5, 4, 2]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * <p>
 * 测试用例:
 * {5,4,3,1,4,7} true
 * {4,5,1,7}  true
 * {6,5,4,3,2} false
 * <p>
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class IncreasingTriplet334 {
    public static boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        //妙啊，按顺序遍历的，比之前的a大，再比之前的b大就说明有递增的子序列
        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                //num > b > a
                return true;
            }
        }
        return false;
    }

    /*
     * 先计算出最长递增子序列长度，然后判断长度是否大于等于3
     * */
    public static boolean increasingTriplet2(int[] nums) {
        int max = 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(dp[j], temp);
                }
            }
            dp[i] = ++temp;
            max = Math.max(max, temp);
        }
        return max >= 3;
    }


    /*
     * 长度为 4 的递增子序列
     * */
    public static boolean increasingFour(int[] nums) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else if (num <= c) {
                c = num;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 7};
        System.out.println(increasingTriplet2(array));
    }
}

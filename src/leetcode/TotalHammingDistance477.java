package leetcode;

/**
 * input:[2,4,14]
 * output:6
 * <p>
 * 0010 0100 1110
 * 1的个数 0的个数
 * 第一位 1  *  2
 * 第二位 2  *  1
 * 第三位 2  *  1
 * 第四位 0  *  3
 * 所以问题转换为了算多少对01组合
 *
 * @auther : wangyufei
 * @date : 2020-01-31
 **/
public class TotalHammingDistance477 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 14};
        int res = totalHammingDistance2(nums);
        System.out.println(res);

    }

    public static int totalHammingDistance(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                sum += hammingDistance(nums[i], nums[j]);
            }
        }
        return sum;
    }

    public static int hammingDistance(int x, int y) {
        int res = x ^ y;
        int distance = 0;
        while (res != 0) {
            if (res % 2 == 1) distance++;
            res /= 2;
        }
        return distance;
    }

    public static int totalHammingDistance2(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < 30; i++) {
            int oneCount = 0;
            int temp = 0;
            for (int j = 0; j < len; j++) {
                oneCount += nums[j] & 1;
                nums[j] >>= 1;
                temp += nums[j] == 0 ? 1 : 0;
            }
            sum += oneCount * (len - oneCount);
            //已经过了最大数的最高有效位了
            if (temp == len) break;
        }
        return sum;

    }
}

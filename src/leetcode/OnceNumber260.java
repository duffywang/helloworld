package leetcode;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * input:[1,2,1,3,2,5]
 * output:[3,5]
 *
 * @auther : wangyufei
 * @date : 2020-01-27
 **/
public class OnceNumber260 {
    public static void main(String[] args) {
        int[] input = {1, 2, 1, 3, 2, 5};
        int[] res = singleNumber(input);
        for (int re : res) {
            System.out.print(re);

        }


    }

    public static int[] singleNumber(int[] nums) {
        int num1 = 0, num2 = 0;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int bit = 1;
        while ((xor & 1) == 0) {
            xor >>= 1;
            bit <<= 1;
        }
        for (int num : nums) {
            if ((num & bit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};

    }
}

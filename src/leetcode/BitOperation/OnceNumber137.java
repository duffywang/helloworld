package leetcode.BitOperation;

/**
 * @auther : wangyufei
 * @date : 2020-01-22
 **/
public class OnceNumber137 {
    public static void main(String[] args) {
        int[] input = {2, 2, 3, 2};

    }

    public static int getOnceNumber(int[] input) {
        int len = input.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if ((input[j] >>> i & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans = ans | 1 << i;
            }
        }
        return ans;

    }
}

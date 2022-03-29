package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-01-18
 * @despriction : 从数组中找出和为目标值的那两个整数
 * @example : [2,7,11,15] target = 9 res = [0,1]
 **/
public class TwoNumberSum1 {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15, 34, 71, -3};
        int target = 5;
        int length = input.length;
        if (length < 2) System.out.println("no exist");
        for (int i = 0; i < length; i++) {
            int res = target - input[i];
            for (int j = i + 1; j < length; j++) {
                if (input[j] == res) {
                    int index0 = i;
                    int index1 = j;
                    System.out.println(index0 + "," + index1);
                }
            }
        }
    }
}

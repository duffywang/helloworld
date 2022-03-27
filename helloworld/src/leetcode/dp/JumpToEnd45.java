package leetcode.dp;

/**
 * @auther : wangyufei
 * @date : 2020-01-17
 **/
public class JumpToEnd45 {

    public static void main(String[] args) {
        int[] input = {5, 3, 1, 1, 1, 4};
        int[] input2 = {2,3,1,1,4};
        int[] input3 = {1,2,1,1,1};
        int result = jump(input3);
        System.out.println(result);

    }

    public static int jump(int[] input) {
        if (input.length == 1) return 0;
        int reach = 0;
        int nextreach = input[0];
        int step = 0;
        for (int i = 0; i < input.length - 1; i++) {
            nextreach = Math.max(i + input[i], nextreach);
            if (nextreach >= input.length - 1) return step + 1;
            //一步步走
            if (i == reach) {
                step++;
                reach = nextreach;
            }
        }
        return step;
    }

    public static int jump2(int[] nums) {
        int len = nums.length;
        int maxReach = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (maxReach >= len-1) return count;
            count++;
            maxReach = Math.max(nums[i] + i, maxReach);
        }
        return count;

    }
}

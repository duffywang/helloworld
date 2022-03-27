package leetcode.Stack;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * input:[73, 74, 75, 71, 69, 72, 76, 73]，
 * output:[1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * @auther : wangyufei
 * @date : 2020-01-27
 **/
public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] input2 = {73, 74, 75, 76, 77};
        int[] input3 = {4,1,2,5};

        int[] res = dailyTemperatures2(input3);
        for (int i : res) {
            System.out.print(i);
        }

    }

    /**
     * 直观方法使用双循环
     */
    public static int[] dailyTemperatures(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = j - i;
                    break;
                }
                if (j + 1 == nums.length) {
                    res[i] = 0;
                }
            }
        }
        return res;

    }

    /**
     * 单调栈
     */
    public static int[] dailyTemperatures2(int[] nums) {
        //存放索引
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            //当前的值大，后面的值小，放弃后面的值，记录当前大值的索引进栈，即谁大之前的就先看到谁
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                //注意是while 而不是 if ,避免4 1 2 5 这种情况
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}

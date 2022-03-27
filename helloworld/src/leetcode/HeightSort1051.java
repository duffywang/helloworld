package leetcode;

import java.util.Arrays;

/**
 * \请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 * input:[9, 1, 4, 2, 1, 3]
 * output:[1, 1, 2, 3, 4, 9]
 *
 * @auther : wangyufei
 * @date : 2020-01-27
 **/
public class HeightSort1051 {
    public static void main(String[] args) {
        int[] nums = {9, 1, 4, 2, 1, 3};
        int res = heightChecker2(nums);
        System.out.println(res);

    }

    public static int heightChecker(int[] heights) {
        int[] init = heights.clone();

        Arrays.sort(heights);
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            if (init[i] != heights[i]) {
                sum++;
            }
        }
        return sum;

    }

    public static int heightChecker2(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;

        for (int i = 0, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;

    }

}

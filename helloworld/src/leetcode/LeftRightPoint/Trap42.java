package leetcode.LeftRightPoint;

/**
 * @auther : wangyufei
 * @date : 2020-10-07
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 思路1：计算每个位置上能接到的雨水，然后积累所有位置的值
 * get(i) = min(l_max,r_max) - height(i)
 * <p>
 * 思路2：双指针法
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 **/
public class Trap42 {
    public static int trap(int[] height) {
        int len = height.length;
        if (len < 3) return 0;
        int[] l_Array = new int[len];
        int[] r_Array = new int[len];
        l_Array[0] = height[0];
        r_Array[len - 1] = height[len - 1];
        int res = 0;
        for (int i = 1; i < len; i++) {
            l_Array[i] = Math.max(height[i], l_Array[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            r_Array[i] = Math.max(height[i], r_Array[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(l_Array[i], r_Array[i]) - height[i];
        }

        return res;
    }

    public static int trap2(int[] height) {
        int len = height.length;
        int res = 0;
        int left = 0, right = len - 1;
        int lMax = height[0];
        int rMax = height[len - 1];

        while (left <= right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);

            //为什么要比较
            if (lMax < rMax) {
                res += lMax - height[left];
                left++;
            } else {
                res += rMax - height[right];
                right--;
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = trap2(array);
        System.out.println(res);
    }
}

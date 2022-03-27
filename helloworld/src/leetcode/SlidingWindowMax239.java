package leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 *
 * @auther : wangyufei
 * @date : 2020-01-31
 * 1 1 3 3 -1 3
 **/
public class SlidingWindowMax239 {
    ArrayDeque<Integer> dep = new ArrayDeque<Integer>();
    int[] nums;

    public static void main(String[] args) {
        int[] input = {6, 3, -1, -3, -5, -13, 6, 7};
        SlidingWindowMax239 slidingWindowMax239 = new SlidingWindowMax239();
        int[] res = slidingWindowMax239.maxSlidingWindow2(input, 3);
        for (int re : res) {
            System.out.println(re);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int outputLen = len - k + 1;
        if (len * k == 0) return new int[0];
        if (k == 1) return nums;
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            dep.addLast(i);
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int[] res = new int[outputLen];
        res[0] = nums[max_idx];
        for (int i = k; i < len; i++) {
            cleanDeque(i, k);
            dep.addLast(i);
            res[i - k + 1] = nums[dep.getFirst()];
        }
        return res;
    }

    private void cleanDeque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!dep.isEmpty() && dep.getFirst() == i - k) {
            //remove head
            dep.removeFirst();
        }
        // remove from deq indexes of all elements which are smaller than current element nums[i]
        while (!dep.isEmpty() && nums[i] > nums[dep.getLast()]) {
            //remove tail
            dep.removeLast();
        }
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] res = new int[len - k + 1];
        int i, j;
        int maxPos = -1;
        for (i = 0; i < len - k + 1; i++) {
            //滑动窗范围
            j = i + k - 1;
            //窗的最大值是最右的值
            if (maxPos != -1 && nums[j] >= nums[maxPos]) {
                maxPos = j;
                res[i] = nums[maxPos];
            } else if (i <= maxPos) {
                //最大值在窗内
                res[i] = nums[maxPos];
            } else {
                //新的窗内选取最大值
                int maxWindow = Integer.MIN_VALUE;
                int temp = 0;
                for (int z = i; z <= j; z++) {
                    if (nums[z] > maxWindow) {
                        temp = z;
                        maxWindow = nums[z];
                    }
                }
                maxPos = temp;
                res[i] = maxWindow;
            }
        }
        return res;

    }
}



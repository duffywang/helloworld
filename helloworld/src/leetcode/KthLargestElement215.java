package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素
 * input:[3,2,1,5,6,4] 2  [1,2,3,4,5,6]
 * output:5
 *
 * @auther : wangyufei
 * @date : 2020-02-02
 **/
public class KthLargestElement215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int res = findKthLargest2(nums, 2);
        System.out.println(res);
    }


    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k){
                heap.poll();
            }
        }
        return heap.poll();


    }

}

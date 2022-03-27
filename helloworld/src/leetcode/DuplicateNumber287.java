package leetcode;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 * input:[1,3,4,2,2]
 * output:2
 *
 * 通过位图的思想，作为下标去处理
 *
 * @auther : wangyufei
 * @date : 2020-02-05
 **/
public class DuplicateNumber287 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int res = findDuplicate(nums);
        System.out.println(res);
    }

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int[] array = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (array[nums[i]] == 1) {
                array[nums[i]] = -1;
                break;
            }
            array[nums[i]] = 1;
        }
        int j = 1;
        for (; j < len; j++) {
            if (array[j] == -1) break;
        }
        return j;
    }

}

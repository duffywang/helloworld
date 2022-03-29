package leetcode;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * input:[0,1,1,1,1,2,2,3]
 * output:5 (0,1,1,2,2,3)
 * <p>
 * 思路：利用排序数组和最多出现两次的条件
 *
 * @auther : wangyufei
 * @date : 2020-02-09
 **/
public class RemoveDuplicateArrayElement80 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 1, 2, 2, 3};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        }
        return i;
    }
}

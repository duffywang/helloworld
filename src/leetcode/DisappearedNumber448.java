package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * * 找出 1 - n 中没有出现的数字。不能使用额外的空间，两次循环时间复杂度为 2O(n)，即为 O(n)。
 * *
 * * 解题思路：使用数组的下标来标记数字的出现于否，通过一遍遍历即可标记出全部已经出现的数组
 * *
 * * [4,3,2,7,8,2,3,1] 初始数据
 * *
 * * [4,3,2,-7,8,2,3,1] 第一个数据 4 出现，将数组的第四个也就是下标 3 的数据修改为负数。-7 计算时，通过绝对值处理一下即可不影响数据的计算
 * * [4,3,-2,-7,8,2,3,1]
 * * [4,-3,-2,-7,8,2,3,1]
 * * [4,-3,-2,-7,8,2,-3,1]
 * * [4,-3,-2,-7,8,2,-3,-1]
 * * [4,-3,-2,-7,8,2,-3,-1]
 * * [4,-3,-2,-7,8,2,-3,-1]
 * * [-4,-3,-2,-7,8,2,-3,-1]
 * 考虑用位图的思想，如果设为1了就会覆盖之前的值的大小，通过设为负数来，
 * 绝对值就可以标明哪一位存在，为正数的位说明数据缺失
 *
 * @auther : wangyufei
 * @date : 2020-01-27
 **/
public class DisappearedNumber448 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 6, 1, 8, 1, 7};
        List<Integer> res = findDisappearedNumbers(nums);
        System.out.println(res);

    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[(Math.abs(nums[i]) - 1)]);
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;


    }


}

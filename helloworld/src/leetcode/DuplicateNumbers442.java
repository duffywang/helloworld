package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * [5,4,6,7,9,3,10,9,5,6]
 * [4,3,2,7,8,2,3,1]
 * [4,3,2,-7,8,2,3,1]
 * [4,3,-2,-7,8,2,3,1]
 * [4,-3,-2,-7,8,2,3,1]
 * [4,-3,-2,-7,8,2,-3,1]
 * [4,-3,-2,-7,8,2,-3,-1]
 * [4,0,-2,-7,8,2,-3,-1]
 * [4,0,0,-7,8,2,-3,-1]
 * [-4,0,0,-7,8,2,-3,-1]
 * <p>
 * /**[5,4,6,7,9,3,10,9,5,6]
 *
 * @auther : wangyufei
 * @date : 2020-01-27
 **/
public class DuplicateNumbers442 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 6, 7, 9, 3, 10, 9, 5, 6};
        List<Integer> res = findDuplicates(nums);
        System.out.println(res);

    }

    public static List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = nums.length;
        int num = 0;
        for (int i = 0; i < len; i++) {
            num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else {
                list.add(num);
            }
        }
        return list;

    }
}

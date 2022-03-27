package leetcode;

import java.util.stream.IntStream;

/**
 * @auther : wangyufei
 * @date : 2021-06-26
 **/
public class ContainsDuplicate217 {
    public static boolean containsDuplicate(int[] nums) {

        return IntStream.of(nums).distinct().count() != nums.length;

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,1};
        boolean res = containsDuplicate(array);

    }
}

package leetcode.Sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @auther : wangyufei
 * @date : 2021-06-09
 * <p>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 **/
public class LargestNumber179 {
    public static String largestNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //String.compareTo 第一次用
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        //[0,0] -> "00" -> "0"
        if (array[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] array = {3, 30, 34, 5, 9};
        String s = largestNumber(array);
        System.out.println(s);
    }

}

package swordoffer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @auther : wangyufei
 * @date : 2020-08-16
 * <p>
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 **/
public class MinNumber45 {
    public static String minNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        return String.join("", list);

    }

    public static void main(String[] args) {
        int[] array = {7, 3, 30, 34, 9, 5};
        String res = minNumber(array);
        System.out.println(res);
    }
}

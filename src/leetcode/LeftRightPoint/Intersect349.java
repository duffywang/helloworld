package leetcode.LeftRightPoint;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2020-09-26
 * 给定两个数组，编写一个函数来计算它们的交集，交集不重复。
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 **/
public class Intersect349 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left1 = 0, left2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        while (left1 < len1 && left2 < len2) {
            if (nums1[left1] == nums2[left2]) {
                // 保证交集不重复
                if (res.isEmpty() || res.get(res.size() - 1) != nums1[left1]) {
                    res.add(nums1[left1]);
                }
                left1++;
                left2++;
            } else if (nums1[left1] < nums2[left2]) {
                left1++;
            } else {
                left2++;
            }
        }
        int[] array = new int[res.size()];
        int i = 0;
        for (Integer re : res) {
            array[i++] = re;
        }
        return array;

    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] res = intersect(num1, num2);
        for (int re : res) {
            System.out.println(re);
        }
    }
}

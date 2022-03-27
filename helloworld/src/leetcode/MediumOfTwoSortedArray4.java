package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-01-30
 **/
public class MediumOfTwoSortedArray4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 7};
        int[] nums2 = {-1, 1, 3, 6, 10};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);


    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] nums = new int[len];
        int index1 = 0, index2 = 0;
        int i = 0;
        for (; i < len && index1 < len1 && index2 < len2; i++) {
            if (nums1[index1] <= nums2[index2]) {
                nums[i] = nums1[index1++];
            } else {
                nums[i] = nums2[index2++];
            }
        }
        while (index1 < len1) {
            nums[i++] = nums1[index1++];
        }
        while (index2 < len2) {
            nums[i++] = nums2[index2++];
        }
        if ((len) % 2 == 1) {
            return new Double(nums[len / 2]);
        } else {
            return new Double((nums[len / 2 - 1] + nums[len / 2])) / 2;
        }

    }
}

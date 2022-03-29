package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-07-15
 * <p>
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 **/
public class SingleNonDuplicate540 {


    public static int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }


    /*O(log n)时间复杂度和 O(1)空间复杂度中运行
     *O(log N) 及 有序数组暗示要用二分法
     * 在单个元素的后面，则成对的元素变为奇数索引后跟他们的同一元素。
     * 说明我们在检索单个元素后面的偶数索引时，其后都没有它的同一元素。因此，我们可以通过偶数索引确定单个元素在左侧还是右侧。
     * */
    public static int singleNonDuplicate2(int[] nums) {
        //输入数组为奇数，那么lo和hi为偶数
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            //如果mid为奇数，则减1成为偶数
            if (mid % 2 == 1) mid--;
            //如果相同则说明在右边
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                //不相同说明在左边
                hi = mid;
            }
        }
        return nums[lo];
    }


    public static void main(String[] args) {
        int[] array = {1, 8, 8, 9, 9};
        int res = singleNonDuplicate2(array);
        System.out.println(res);
    }

}

package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-07-15
 **/
public class FindReapeatNumber {
    public static int findRepeatNumber(int[] nums) {
        int[] array = new int[nums.length];
        for (int num : nums) {
            //如果是负数将越界，该如何处理呢？最常规的使用hashmap处理
            if (array[num] == 1) {
                return num;
            }
            array[num] = 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {-2, 3, 1, 0, -2};
        int[] array2 = {2, 3, 1, 0, 2};
        int res = findRepeatNumber(array);
        System.out.println(res);
    }
}

package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-05-20
 * 2N 大小的数组，N个奇数，N个偶数，将奇数放在坐标为奇数的位置，偶数放在坐标为偶数的位置上
 **/
public class EvenOdd {

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2, 7, 2, 3, 10, 6};
        int length = array.length;
        int i = 0;
        int j = length - 1;
        while (i < length && j >= 0) {
            while (i < length && !even(i, array[i])) {
                i++;
            }
            while (j >= 0 && !odd(j, array[j])) {
                j--;
            }
            if (i < length && j >= 0) {
                switchPos(i, j, array);
                i++;
                j--;
            }
        }
        for (int res : array) {
            System.out.println(res);
        }


    }

    private static void switchPos(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static boolean even(int pos, int data) {
        if (pos % 2 == 0 && data % 2 != 0) {
            return true;
        }
        return false;
    }

    public static boolean odd(int pos, int data) {
        if (pos % 2 != 0 && data % 2 == 0) {
            return true;
        }
        return false;

    }
}

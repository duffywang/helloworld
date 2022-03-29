package leetcode;

import java.util.Random;

/**
 * @auther : wangyufei
 * @date : 2020-09-23
 * <p>
 * Collections.shuffle()
 **/
public class Shuffle {
    public static void shuffle1(int[] array) {
        Random random = new Random();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int rand = random.nextInt(len - i) + i;
            swap(array, i, rand);
        }
/*        for(int i = len; i > 1;i--){
            swap(array, i-1, random.nextInt(i));
        }*/


    }

    private static void swap(int[] array, int i, int rand) {
        int temp = array[i];
        array[i] = array[rand];
        array[rand] = temp;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        shuffle1(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}

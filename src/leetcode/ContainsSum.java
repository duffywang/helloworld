package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @auther : wangyufei
 * @date : 2020-09-01
 **/
public class ContainsSum {
    public static boolean containsSum(int[] numbers, int sum) {
        int len = numbers.length;
        if (len < 2) return false;
        Arrays.sort(numbers);
        for (int i = 0, j = len - 1; i < j; ) {
            if (numbers[i] + numbers[j] == sum) {
                return true;
            }
            while (i < j && numbers[i] + numbers[j] > sum) {
                j--;
            }
            while (i < j && numbers[i] + numbers[j] < sum) {
                i++;
            }
        }
        return false;

    }

    public static boolean containsSum2(int[] numbers, int sum) {
        int len = numbers.length;
        if (len < 2) return false;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(numbers[i])) {
                map.put(numbers[i], true);
            } else {
                map.put(numbers[i], false);
            }
        }
        for (int i = 0; i < len; i++) {
            if (map.containsKey(sum - numbers[i])) {
                if (numbers[i] == sum - numbers[i] && map.get(numbers[i])) {
                    return true;
                }
                if (numbers[i] != sum - numbers[i]) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] array = {2, 3, 6, 1, 7, 8};
        boolean res = containsSum2(array, 15);
        System.out.println(res);
    }
}

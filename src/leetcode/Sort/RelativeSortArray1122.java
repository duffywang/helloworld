package leetcode.Sort;

import java.util.Map;
import java.util.TreeMap;

/**
 * @auther : wangyufei
 * @date : 2021-06-15
 **/
public class RelativeSortArray1122 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int index = 0;
        for (int i : arr2) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                for (int j = 0; j < count; j++) {
                    arr1[index++] = i;
                }
                map.remove(i);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            for (int i = 0; i < count; i++) {
                arr1[index++] = entry.getKey();
            }
        }
        return arr1;


    }

    //不用TreeMap 使用桶
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {

        int[] map = new int[1001];
        int[] ans = new int[arr1.length];
        int max = Integer.MIN_VALUE;

        for (int num : arr1) {
            map[num]++;
            max = Math.max(max, num);
        }

        int index = 0;

        for (int num : arr2) {

            while (map[num] > 0) {
                ans[index++] = num;
                map[num]--;
            }
        }

        for (int i = 0; i < max + 1; i++) {

            while (map[i] > 0) {
                ans[index++] = i;
                map[i]--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] res = relativeSortArray(arr1, arr2);
        for (int re : res) {
            System.out.println(re);
        }
    }
}

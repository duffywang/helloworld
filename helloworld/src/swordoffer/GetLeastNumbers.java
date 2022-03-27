package swordoffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @auther : wangyufei
 * @date : 2020-07-19
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 **/
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int lo, int hi, int k) {
        int j = partition(arr, lo, hi);
        if (j == k) return Arrays.copyOf(arr, j + 1);
        return j > k ? quickSearch(arr, lo, j - 1, k) : quickSearch(arr, j + 1, hi, k);

    }

    private int partition(int[] arr, int lo, int hi) {
        int v = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && arr[i] < v) ;
            while (--j >= lo && arr[j] > v) ;
            if (i >= j) {
                break;
            }
            int t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }
        arr[lo] = arr[j];
        arr[j] = v;
        return j;

    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        //默认是从小到大的，设置为从大到小的
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : arr) {
            if (queue.size() < k) {
                queue.add(i);
            } else if (queue.peek() > i) {
                //peek查看的第一位数，如果最大的数大于未加入的数，则移除queue中第一位数
                queue.remove();
                queue.add(i);
            }
        }
        int[] res = new int[k];
        int count = 0;
        for (Integer q : queue) {
            res[count++] = q;
        }
        return res;

    }

    //找到数组中最大的k个数
    public static int[] getGreatNumbers(int[] arr, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] res = new int[k];
        for (int a : arr) {
            if (queue.size() < k){
                queue.add(a);
            }else if (queue.peek() < a){
                queue.remove();
                queue.add(a);
            }
        }
        int index = 0;
        for (Integer q : queue) {
            res[index++] = q;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};
        int[] res = getGreatNumbers(array, 6);
        System.out.println(Arrays.toString(res));

    }
}

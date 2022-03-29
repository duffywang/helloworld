package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-10-11
 * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。
 * 我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 * <p>
 * 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确
 * <p>
 * 输入：[3,2,4,1]
 * 输出：[4,2,4,3]
 * 解释：
 * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 * 初始状态 A = [3, 2, 4, 1]
 * 第一次翻转后 (k=4): A = [1, 4, 2, 3]
 * 第二次翻转后 (k=2): A = [4, 1, 2, 3]
 * 第三次翻转后 (k=4): A = [3, 2, 1, 4]
 * 第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
 *
 *
 * <p>
 * 3,2,4,1 3
 * 4,2,3,1 4
 * 1,3,2,4 2
 * 3,1,2,4 3
 * 2,1,3,4 1
 * 1,2,3,4 2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pancake-sorting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class PancakeSort969 {
    static ArrayList<Integer> res = new ArrayList<>();

    public static List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;

    }

    /*
     * 常规思路，先找最大的index,翻到首部，然后再把首部翻到尾部
     * 依次再找次大的
     * 时间复杂度O(n2)
     * */
    public static void sort(int[] arr, int n) {
        if (n == 1) return;
        int index = 0;
        int max = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] > max) {
                index = j;
                max = arr[j];
            }
        }
        //第一次翻转
        reverse(arr, 0, index);
        res.add(index + 1);

        //第二次翻转
        reverse(arr, 0, n - 1);
        res.add(n);
        sort(arr, n - 1);
    }

    //不仅是两个数的翻转
    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }


    public static List<Integer> pancakeSort2(int[] arr) {
        sort(arr, arr.length);
        return res;

    }

    public static void main(String[] args) {
        int[] array = {3, 2, 4, 1};
        List<Integer> res = pancakeSort(array);
        for (Integer re : res) {
            System.out.println(re);
        }

    }
}

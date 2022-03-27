package leetcode.BinarySearch;

import java.util.Random;

/**
 * @auther : wangyufei
 * @date : 2022-02-23
 * 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
 *
 * 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
 *
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-with-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class WeightSelectSolution {

    int[] array;
    int max;
    Random random = new Random();

    public WeightSelectSolution(int[] w) {
        int length = w.length;
        array = new int[length+1];
        int index = 0;
        array[index] = 0;
        for (int i = 0; i < w.length; i++) {
            array[++index] = array[index-1] + w[i];
        }
        max = array[index];

    }

    public int pickIndex() {
        int nextInt = random.nextInt(max);
        int mid,left = 0,right = array.length;
        while(left < right){
             mid = (left+right) / 2;
            if (nextInt > array[mid] && nextInt <= array[mid+1]){
                return mid-1;
            }else if (nextInt > array[mid+1]){
                left = mid;
            }else if(nextInt < array[mid]){
                right = mid+1;
            }
        }
        return 0;
    }
}

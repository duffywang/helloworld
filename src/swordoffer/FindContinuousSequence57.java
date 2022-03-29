package swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-08-17
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FindContinuousSequence57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        //右指针最大长度不会超过（target / 2 + 1）
        for (int l = 1, r = 1, sum = 0; r <= target / 2 + 1; r++) {
            sum += r;
            //如果太小增大右指针r++
            while (sum > target) {
                sum -= l++;
            }
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = l + i;
                }
                list.add(temp);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;


    }

}

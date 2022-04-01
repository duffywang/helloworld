package src.leetcode.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2022-03-31
 *
 * 自除数 是指可以被它包含的每一位数整除的数。
 *
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 *
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-dividing-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SelfDividingNumbers728 {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isValidNumber(i)){
                res.add(i);
            }
        }
        return res;
    }

    private static boolean isValidNumber(int i) {
        int mod,orgin = i;
        while(i != 0){
            mod = i % 10;
            if (mod == 0 || orgin % mod != 0)return false;
            i = i / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> res = selfDividingNumbers(1, 22);
        for (Integer re : res) {
            System.out.println(re);
        }
        System.out.println();
    }
}

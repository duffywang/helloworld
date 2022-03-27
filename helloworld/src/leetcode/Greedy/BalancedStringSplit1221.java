package leetcode.Greedy;

/**
 * @auther : wangyufei
 * @date : 2020-10-18
 **/
public class BalancedStringSplit1221 {
    public int balancedStringSplit(String s) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                count++;
            }
            if (s.charAt(i) == 'R') {
                count--;
            }
            if (count == 0) res++;
        }
        return res;
    }
}

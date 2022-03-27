package leetcode.Greedy;

/**
 * @auther : wangyufei
 * @date : 2022-01-17
 **/
public class MinMoves2139 {
    public static int minMoves(int target, int maxDoubles) {
        int res = 0;
        while (target != 1) {
            while (target % 2 == 0) {
                if (maxDoubles > 0) {
                    maxDoubles--;
                    target /= 2;
                    res++;
                } else {
                    target -= 1;
                    res++;
                }
            }
            while (target != 1 && target % 2 == 1) {
                target -= 1;
                res++;
            }
            if (maxDoubles == 0) {
                res += (target - 1);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minMoves(5, 0));
    }
}

package leetcode.Math;

/**
 * @auther : wangyufei
 * @date : 2022-03-27
 **/
public class MissingRolls2028 {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int count = rolls.length;
        int curSum = 0;
        for (int roll : rolls) {
            curSum += roll;
        }
        int sum = mean * (count + n);
        int last = sum - curSum;
        if (last > 6 * n || last < 2 * n) {
            return new int[0];
        } else {
            int[] res = new int[n];
            int avg = last / n;
            int mod = last - avg * n;
            for (int i = 0; i < n; i++) {
                if (i < mod) {
                    res[i] = avg + 1;
                } else {
                    res[i] = avg;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] rolls = {4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5};
        int[] res = missingRolls(rolls, 4, 40);
        for (int r : res){
            System.out.println(r);
        }

    }
}

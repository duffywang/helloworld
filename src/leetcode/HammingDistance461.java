package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-01-30
 **/
public class HammingDistance461 {
    public static void main(String[] args) {
        int res = hammingDistance(11, 4);
        System.out.println(res);

    }

    public static int hammingDistance(int x, int y) {
        int res = x ^ y;
        int distance = 0;
        while (res != 0) {
            if (res % 2 == 1) distance++;
            res /= 2;
        }
        return distance;
    }
}

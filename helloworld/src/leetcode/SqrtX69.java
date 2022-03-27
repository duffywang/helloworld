package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-05-20
 **/
public class SqrtX69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        int i = 0;
        int j = x;
        int res = -1;
        while (i <= j){
            int mid = i + (j-i)/2;
            //mid * mid <= x -> true
            if ((long)mid * mid <= x){
                i = mid + 1;
                res = mid ;
            }else {
                j = mid - 1;
            }
        }
        return res;



    }
}

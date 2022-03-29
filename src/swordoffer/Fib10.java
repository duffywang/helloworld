package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-07-18
 **/
public class Fib10 {


    public static int fib(int n) {
        if (n == 0 || n == 1) return n;
        int a = 1, b = 0;
        //自底向上构建
        for (int i = 1; i < n; i++) {
            a = a + b;//f(n-1) + f(n-2)
            b = a - b;//新的f(n-2) 为 上一次的f(n-1)
            a = a % 1000000007;
        }

        return a;
        //return fib(n-1) + fib(n-2); 自顶向下，递归次数较多，超时，时间复杂度为O(2^N)，产生重叠子问题
    }


    public static void main(String[] args) {

        int fib = fib(18);
        System.out.println(fib);
    }
}

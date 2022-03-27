package leetcode.ListNodePackage;

import java.util.HashSet;

/**
 * @auther : wangyufei
 * @date : 2022-01-09
 **/
public class IsHappy202 {
    private static HashSet<Integer> set = new HashSet<>();

    public static boolean isHappy(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i)-'0') * (s.charAt(i)-'0');
        }
        if (set.contains(sum))return false;
        set.add(sum);
        return sum == 1 || isHappy(sum);
    }

    public boolean isHappy2(int n) {
        int slow = n,fast = getNext(n);
        while(fast != 1 && slow != fast  ){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while(n > 0){
            int d = n % 10;
            n = n / 10;
            sum = sum + d*d;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}

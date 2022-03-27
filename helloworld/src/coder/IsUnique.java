package coder;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @auther : wangyufei
 * @date : 2020-08-25
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。不使用额外的数据结构
 **/
public class IsUnique {
    public static boolean isUnique(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.lastIndexOf(str.charAt(i)) == str.indexOf(str.charAt(i))) continue;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res1 = isUnique("leetcode");
        boolean res2 = isUnique("abc");
        System.out.println(res1);
        System.out.println(res2);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //
            }
        }, 1000);
    }
}

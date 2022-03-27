package leetcode;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther : wangyufei
 * @date : 2020-07-12
 **/
public class WXHotPacket {
    public static void getHotPacket(int remainCount, double remainMoney){
        if (remainCount == 1){
            System.out.println((double)Math.round(remainMoney * 100)/100);
            return;
        }
        Random random = new Random();
        double min = 0.01;
        double max = remainMoney / remainCount * 2;
        double money = random.nextDouble()*max;
        money = money < min ? min : money;
        money = Math.floor(money * 100) / 100;
        remainCount--;
        remainMoney -= money;
        getHotPacket(remainCount, remainMoney);
        System.out.println(money);
    }

    public static void main(String[] args) {
        getHotPacket(10, 100);
    }
}

package threads;

import java.text.NumberFormat;

/**
 * @auther : wangyufei
 * @date : 2020-08-17
 *
 * 主线程取值: 主线程设置的value
 * Thread-0线程未设置值前取值: null
 * Thread-0线程设置值后取值: Thread-0线程设置的value
 * 主线程取值: 主线程设置的value
 *
 * 我理解就是一个key为各线程的HashMap,set就直接设置value了,省去了(key,value)写法
 *
 **/
public class ThreadlocalTest {
    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(1 << COUNT_BITS);
        local.set("主线程设置的value");//set的类型为ThreadLocal设置的数据类型
        local.set("修改一次了");
        System.out.println("主线程取值: " + local.get());
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程未设置值前取值: " + local.get());
            local.set(Thread.currentThread().getName() + "线程设置的value");
            System.out.println(Thread.currentThread().getName() + "线程设置值后取值: " + local.get());
        }).start();
        Thread.sleep(2000);
        System.out.println("主线程取值: " + local.get());
        System.out.println("NumberFormat: " + nfLocal.get());
    }

    private static ThreadLocal<NumberFormat> nfLocal = new ThreadLocal<NumberFormat>() {
        @Override
        protected NumberFormat initialValue() {
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(3);
            return nf;
        }
    };
}

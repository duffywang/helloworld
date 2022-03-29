package helloworld.src.Async;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @auther : wangyufei
 * @date : 2022-03-14
 **/
public class FutureTest {

    public static void main(String[] args) throws Exception {
        helloworld.src.Async.MyThread myThread = new helloworld.src.Async.MyThread();
        FutureTask<String> task1 = new FutureTask<>(myThread);
        FutureTask<String> task2 = new FutureTask<>(myThread);
        FutureTask<String> task3 = new FutureTask<>(myThread);


        Thread a = new Thread(task1, "A");

        a.start();
        TimeUnit.SECONDS.sleep(1);

        new Thread(task3, "C").start();
        new Thread(task2, "B").start();

        //1.正常 done
        //2.get超时 done debug和正常执行结果不一样，debug可以卡执行时间，记录的currentTime与正常run不同
        //3.异常 done
        //4.中断
        System.out.println(Thread.currentThread().getName() + "开始");
        System.out.println(task1.get(10, TimeUnit.SECONDS));
        Thread.currentThread().interrupt();
        System.out.println(task2.get(10, TimeUnit.SECONDS));
        System.out.println(task3.get(10, TimeUnit.SECONDS));
        System.out.println(Thread.currentThread().getName() + "结束");

    }
}

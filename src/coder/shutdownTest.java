package src.coder;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther : wangyufei
 * @date : 2021-05-18
 **/
public class shutdownTest {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = new ThreadPoolExecutor(
                10,
                10,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        for (int i = 0; i < 1000; i++) {
            service.submit(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("接受中断，不处理~~");
                }
                System.out.println("args = " + Arrays.deepToString(args) + Thread.currentThread().getName());
            });
        }

        service.shutdown();
    }
}

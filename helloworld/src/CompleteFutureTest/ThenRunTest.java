package CompleteFutureTest;

import streams.complexStreamTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * @auther : wangyufei
 * @date : 2021-02-07
 * thenRun实现异步任务A ,执行完激活异步任务B，这种方式激活的异步任务B是拿不到任务A的执行结果
 **/
public class ThenRunTest {
    public static void thenRun() throws ExecutionException, InterruptedException {
        CompletableFuture<String> oneFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                // 任务B得不到hello 结果
                return "hello";
            }
        });

        CompletableFuture<Void> twoFuture = oneFuture.thenRun(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println("over");
            }

        });
        System.out.println(twoFuture.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        thenRun();
    }

    /**
     * result:
     * ForkJoinPool.commonPool-worker-1
     * ForkJoinPool.commonPool-worker-1
     * over
     * null
     * */
}

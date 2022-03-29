package CompleteFutureTest;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @auther : wangyufei
 * @date : 2021-02-07
 * thenAcceptAsync 与thenAccept 最大区别是使用了指定设置回调时间使用自定义线程池线程来执行，即oneFuture使用ForkJoinPool.commonPool 中线程，threeFuture使用自定义线程池中线程
 **/
public class ThenAcceptAsyncTest {
    public static void thenAcceptAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> oneFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                return "hello";
            }
        });


        CompletableFuture<Void> threeFuture = oneFuture.thenAcceptAsync(new Consumer<String>() {
            @Override
            public void accept(String s) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println("after oneFuture: " + s);
            }
        }, new ThreadPoolExecutor(2, 4, 10, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10)));

        // 由于accept(String s)方法没有返回值，所以twoFuture.get() 也会返回null
        System.out.println(threeFuture.get());

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        thenAcceptAsync();
    }

    /**
     * result
     * ForkJoinPool.commonPool-worker-1
     * pool-1-thread-1
     * after oneFuture: hello
     * null
     * */
}
package CompleteFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @auther : wangyufei
 * @date : 2021-02-07
 * thenAccept 实现异步任务A,将任务A的结果作为入参传入异步任务B
 * 与thenRun 最大区别就是可以传入异步任务A的结果
 **/
public class ThenAcceptTest {
    public static void thenAccept() throws ExecutionException, InterruptedException {
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

        CompletableFuture<Void> twoFuture = oneFuture.thenAccept(new Consumer<String>() {
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
        });

        // 由于accept(String s)方法没有返回值，所以twoFuture.get() 也会返回null
        System.out.println(twoFuture.get());

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        thenAccept();
    }

    /**
     * result
     * ForkJoinPool.commonPool-worker-1
     * ForkJoinPool.commonPool-worker-1
     * after oneFuture: hello
     * null
     * */
}

package CompleteFutureTest;

import com.sun.xml.internal.ws.util.CompletedFuture;
import leetcode.CompleteTree958;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @auther : wangyufei
 * @date : 2021-02-07
 * thenApply 特点是有上一个异步任务的输入，有当前异步任务的输出，这个应用面比较广
 **/
public class ThenApplyTest {
    public static void thenApply() throws ExecutionException, InterruptedException {
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
        CompletableFuture<String> twoFuture = oneFuture.thenApply(new Function<String, String>() {
            @Override
            public String apply(String s) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                return s + " world";
            }
        });
        System.out.println(twoFuture.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        thenApply();
    }
    /**
     * result
     * ForkJoinPool.commonPool-worker-1
     * ForkJoinPool.commonPool-worker-1
     * hello world
     * */
}

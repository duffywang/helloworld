package CompleteFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @auther : wangyufei
 * @date : 2021-02-07
 * whenComplete 设置回调函数，当异步任务执行完毕后进行回调，不会阻塞调用线程
 **/
public class WhenCompleteTest {
    public static void whenComplete() throws ExecutionException, InterruptedException {
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

        //添加回调函数
        CompletableFuture<String> twoFuture = oneFuture.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable t) {
                if (null == t) {
                    System.out.println(s);
                } else {
                    System.out.println(t.getLocalizedMessage());
                }
            }
        });
        System.out.println(twoFuture.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        whenComplete();
    }
}

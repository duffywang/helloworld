package CompleteFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @auther : wangyufei
 * @date : 2021-02-07
 * 解释：基于runAsync系列的方法实现无返回值的异步计算：当你异步执行任务不需要返回值可使用此方法，如异步打日志，异步做消息通知
 * 注意：Runable() 是无返回值的，runAsync()里不能填new Callable<T>()
 **/
public class RunAsyncTest {
    public static void runAsync() throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("over");
            }
        });
        System.out.println(future.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        runAsync();
    }

    /**
     * result:
     * over
     * null
     * */
}

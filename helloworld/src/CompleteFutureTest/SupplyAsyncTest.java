package CompleteFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * @auther : wangyufei
 * @date : 2021-02-07
 * 基于supplyAsync方法实现有返回值的异步计算，当执行任务并且需要任务的执行结果时可以使用该方法，如异步对原始数据进行加工，并需要获取加工后的数据。
 * 注意：supplyAsync()的参数为Supply<U> supply</>
 **/
public class SupplyAsyncTest {

    public static void supplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("over");
                return "real over";
            }
        });
        System.out.println(future.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        supplyAsync();
    }

    /**
     * result:
     * over
     * real over
    * */
}

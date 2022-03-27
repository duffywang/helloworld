package CompleteFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * @auther : wangyufei
 * @date : 2021-02-07
 * thenCompose 实现一个当CompleteFuture执行完成执行另一个CompleteFuture
 * 类似cooper 中建task，task之间具有依赖关系
 * TODO:内部实现需要学习
 **/
public class ThenComposeTest {

    public static CompletableFuture<String> doSomethingOne(String num){
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return num;
            }
        });
    }

    public static CompletableFuture<String> doSomethingTwo(String id){
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return id + ": meituan";
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = doSomethingOne("4080").thenCompose(id -> doSomethingTwo(id));
        System.out.println(result.get());
    }

    /**
     * result:
     * 4080: meituan
     * */
}

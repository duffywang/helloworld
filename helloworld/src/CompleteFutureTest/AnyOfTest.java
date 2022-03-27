package CompleteFutureTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * @auther : wangyufei
 * @date : 2021-02-07
 **/
public class AnyOfTest {
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
    public static void anyOf() throws ExecutionException, InterruptedException {
        List<CompletableFuture<String>> futureList =  new ArrayList<>();
        futureList.add(doSomethingOne("1"));
        futureList.add(doSomethingOne("2"));
        futureList.add(doSomethingOne("3"));
        futureList.add(doSomethingOne("4"));

        CompletableFuture<Object> result = CompletableFuture.anyOf(futureList.toArray(new CompletableFuture[futureList.size()]));

        System.out.println(result.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        anyOf();
    }

    /**
     * result
     * 1
     * */
}

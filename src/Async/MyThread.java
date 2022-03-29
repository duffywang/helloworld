package helloworld.src.Async;

import java.util.concurrent.Callable;

/**
 * @auther : wangyufei
 * @date : 2022-03-14
 **/
public class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "Test");

        return "success";
    }
}

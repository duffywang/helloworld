package coder;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @auther : wangyufei
 * @date : 2021-02-20
 **/
public class TomcatThreadPool {

    public int createThreadPool() {
        BlockingQueue queue = new LinkedBlockingQueue<String>(10) {
            //激进线程池
            public boolean offer(Runnable r) {
                //先返回false,造成队列满的假象，让线程池优先扩容
                return false;
            }
        };

        new ThreadPoolExecutor(2, 5, 5, TimeUnit.MILLISECONDS, queue, new ThreadFactoryBuilder().setNameFormat("demo-threadpool-%d").build(), (r, executor) -> {
            try {
                //RejectedExecutation拒绝策略一：当出现拒绝后,塞入队列
                executor.getQueue().put(r);
                //RejectedExecutation拒绝策略二：抛出异常
                if (!executor.getQueue().offer(r, 0, TimeUnit.MILLISECONDS)) {
                    throw new RejectedExecutionException();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        return 0;
    }
}

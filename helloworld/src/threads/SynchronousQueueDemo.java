package threads;

import java.util.concurrent.SynchronousQueue;

/**
 * @auther : wangyufei
 * @date : 2022-03-20
 **/
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        Thread putThread1 = new Thread(() -> {
            System.out.println("put thread start");

            try {
                //阻塞了，必须有线程来消费才行
                synchronousQueue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("put thread end");
        });

        Thread putThread2 = new Thread(() -> {
            System.out.println("put thread2 start");

            try {
                //阻塞了，必须有线程来消费才行
                synchronousQueue.put(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("put thread2 end");
        });


        Thread takeThread = new Thread(() -> {
            System.out.println("take thread start");
            try {
                    Integer take = synchronousQueue.take();
                    System.out.println("take thread get: " + take);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("take thread end");
        });

        putThread1.start();
        putThread2.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeThread.start();

    }
}

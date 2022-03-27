package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @auther : wangyufei
 * @date : 2020-08-09
 **/
public class H2O2 {

    private CyclicBarrier c;
    private Semaphore h ;
    private Semaphore o ;

    public H2O2() {
        this.c = new CyclicBarrier(3);
        this.h = new Semaphore(2);
        this.o = new Semaphore(1);

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            c.await();
            h.release();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            c.await();
            o.release();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}

package threads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @auther : wangyufei
 * @date : 2020-08-09
 **/
class ZeroEvenOdd {
    private int n;
    private Semaphore z = new Semaphore(1);
    private Semaphore e = new Semaphore(0);
    private Semaphore o = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            z.acquire();// 减1
            printNumber.accept(i);
            if (n % 2 == 1) {
                o.release();//加1
            } else {
                e.release();
            }

        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i < n; i += 2) {
            e.acquire();
            printNumber.accept(i);
            z.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i < n; i += 2) {
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);

    }
}
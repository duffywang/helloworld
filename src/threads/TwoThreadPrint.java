package threads;

/**
 * @auther : wangyufei
 * @date : 2020-07-06
 **/
public class TwoThreadPrint implements Runnable {

    private static final String[] charArr = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public TwoThreadPrint() {
        super();
    }

    public static void main(String[] args) {
        Object lock = new Object();


        new Thread(new TwoThreadPrint(), "p1").start();
        new Thread(new TwoThreadPrint(), "p2").start();

    }

    @Override
    public void run() {
        synchronized (TwoThreadPrint.class) {
            for (int i = 1; i <= 26; i++) {
                if (Thread.currentThread().getName().equals("p1")) {
                    System.out.print(i);
                    TwoThreadPrint.class.notifyAll();
                    try {
                        TwoThreadPrint.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                if (Thread.currentThread().getName().equals("p2")) {
                    System.out.print(charArr[i - 1]);
                    TwoThreadPrint.class.notifyAll();
                    try {
                        TwoThreadPrint.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

}

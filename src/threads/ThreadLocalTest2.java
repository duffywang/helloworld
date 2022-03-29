package threads;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther : wangyufei
 * @date : 2021-04-11
 **/
public class ThreadLocalTest2 {
    private static ThreadLocal<Session> session = ThreadLocal.withInitial(() -> new Session());

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 60, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));

    public static class Session {
        private String id;
        private String user;
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public String getUser() {
        return session.get().getUser();
    }

    public String getStatus() {
        return session.get().getStatus();
    }

    public void setStatus(String status) {
        session.get().setStatus(status);
    }


    public static void main(String[] args) {
        ThreadLocalTest2 sessionHandler = new ThreadLocalTest2();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(new WorkerThreadTest(i, sessionHandler));
        }

    }

    private static class WorkerThreadTest implements Runnable {

        public WorkerThreadTest(int value, ThreadLocalTest2 sessionHandler) {
            this.value = value;
            this.sessionHandler = sessionHandler;
        }

        private int value;

        ThreadLocalTest2 sessionHandler;


        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println(sessionHandler.getStatus());
            sessionHandler.getUser();
            sessionHandler.setStatus("close");
            System.out.println(sessionHandler.getStatus());
        }
    }
}

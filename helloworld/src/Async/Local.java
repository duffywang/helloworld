package Async;


/**
 * @auther : wangyufei
 * @date : 2022-03-14
 **/
public class Local implements Callback,Runnable {

    private Remote remote;

    private String message;

    public Local(Remote remote, String message) {
        super();
        this.remote = remote;
        this.message = message;
    }

    public void sendMessage(){
        //1.main
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(this);
        //为什么让一个线程来做消息发送，因为是不想影响主线程执行
        thread.start();
        //2.
        System.out.println("Message has been sent by local");
    }

    public static void main(String[] args) {

        Local local = new Local(new Remote(), "Hello");
        /*
        * 客户端 - 新建线程 - 发起调用 - 服务端 - 执行
        *
        * 理解入参我们一般传的是具体参数，现在我们传的是客户端实现的接口，服务端可以执行客户端代码
        * */
        local.sendMessage();
    }

    @Override
    public void execute(Object... objects) {
        /**打印返回的消息**/
        //5.
        System.out.println(objects[0]);
        /**打印发送消息的线程名称**/
        //6.子线程
        System.out.println(Thread.currentThread().getName());
        /**中断发送消息的线程**/
        Thread.interrupted();
    }

    @Override
    public void run() {
        remote.executeMessage(message,this);
    }
}

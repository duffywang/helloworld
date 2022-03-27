package Async;

/**
 * @auther : wangyufei
 * @date : 2022-03-14
 **/
public class Remote {


    public void executeMessage(String msg, Callback callback){
        //3.
        System.out.println(msg);
        //4.
        System.out.println("I hava executed the message by Local1");
        callback.execute(new String[]{"Nice to meet u"});
    }
}

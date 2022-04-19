package src.lighting.task;

import src.main.java.util.InvocationCallback;

/**
 * @auther : wangyufei
 * @date : 2020-10-25
 **/
public class CallbackWork<T> extends AbstractWork<T> implements InvocationCallback {

    /**
     * 默认权重
     */
    private int weight = 10;


    @Override
    public void sendRequest() {
        if (!shouldDo()) {
            markFinished();
            return;
        }

        if (!markProcessing()) {
            return;
        }
        //判断是否需要限流处理

        try {
            //Callback框架必要动作
            //执行业务的调用逻辑
            execute();
        } catch (Exception e) {
            e.printStackTrace();
            markFailure();
        } finally {
        }

    }

    @Override
    public void onSuccess(Object result) {
        try {
            //执行业务自定义的处理逻辑
            callback((T) result);
        } catch (Exception e) {
            //log
            e.printStackTrace();
        } finally {

        }
        markFinished();

    }

    @Override
    public void onFailure(Throwable e) {
        try {
            failed(e);
        } catch (Exception ex) {
            //log
            ex.printStackTrace();
        } finally {

        }
        markFailure();

    }
}

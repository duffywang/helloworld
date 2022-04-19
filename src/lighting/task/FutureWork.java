package src.lighting.task;

import src.main.java.entity.Constants;
import src.main.java.entity.NodeStatusConstant;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @auther : wangyufei
 * @date : 2020-10-25
 **/
public class FutureWork<T> extends AbstractWork<T> {

    private int weight = 3;

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void sendRequest() {
        if (!shouldDo()) {
            markFinished();
            return;
        }
        if (!markProcessing()) {
            return;
        }

        //判断是否需要限流，业务可以自定义限流器


        try {
            execute();
        } catch (Exception e) {
            e.printStackTrace();
            markFailure();
        } finally {

        }


        Object result = null;
        //从RPC框架获取future,以线程维度
        Future future = null;
        int state = NodeStatusConstant.FINISHED;

        try {
            future.get(getTimeout() > 0 ? getTimeout() : Constants.FUTURE_DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            markFailure();
        }

        try {
            callback((T) result);
        } catch (Exception e) {
            e.printStackTrace();
            state = NodeStatusConstant.FAILURE;
        }

        if (state == NodeStatusConstant.FAILURE) {
            markFailure();
        } else {
            markFinished();
        }


    }
}

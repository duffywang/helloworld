package src.lighting.task;

import src.main.java.RPCWeights;
import src.main.java.factory.LogFactory;

import java.util.logging.Logger;

/**
 * @auther : wangyufei
 * @date : 2020-10-25
 **/
public abstract class SyncWork<T> extends AbstractWork {
    private Logger logger = LogFactory.getGlobalLog();

    private int weight = RPCWeights.syncWeight;


    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public final void sendRequest() {
        if (!shouldDo()) {
            markFinished();
            return;
        }
        if (!markProcessing()) {
            return;
        }
        try {
            execute();
        } catch (Exception e) {
            logger.info("sync work exception");
        }
    }

    @Override
    public void execute() {
        super.execute();
    }

    @Override
    public boolean callback(Object result) throws InterruptedException {
        return super.callback(result);
    }
}

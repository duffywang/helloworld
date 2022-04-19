package src.lighting.util;

/**
 * @auther : wangyufei
 * @date : 2022-04-02
 **/
public interface InvocationCallback {
    void onSuccess(Object result);

    void onFailure(Throwable e);
}

package Async;

/**
 * @auther : wangyufei
 * @date : 2022-03-14
 *
 * 异步Callback指调用发出后，调用者不会立刻得到结果，而是在调用发出后，被调用者通知调用者，或者通过回调函数处理这个调用。
 **/
public interface Callback {

    public void execute(Object... objects);
}

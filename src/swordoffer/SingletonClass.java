package swordoffer;

/**
 * @auther : wangyufei
 * @date : 2020-08-18
 **/
class Singleton {

    private Singleton() {
    }

    //饿汉模式，volatile修饰防止代码重排序
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    return new Singleton();
                }
            }
        }
        return instance;
    }
}

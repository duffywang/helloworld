package helloworld.src.coder;

/**
 * @auther : wangyufei
 * @date : 2021-05-14
 **/
public class TimeCompareUtils {

    public static boolean greaterThanOneHour(long duration) {
        return duration >= 3600 * 1000;
    }
}

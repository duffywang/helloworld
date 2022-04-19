package src.lighting.factory;

/**
 * @auther : wangyufei
 * @date : 2020-10-25
 **/

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogFactory {

    // 全局Log的名称
    public static final String LOG_NAME = "Global";

    // 静态变量globleLog
    private static Logger globalLog;

    static {

        // 加载类的时候直接初始化globleLog
        globalLog = initGlobalLog();
    }

    /**
     * 初始化全局Logger
     *
     * @return
     */
    public static Logger initGlobalLog() {

        // 获取Log
        Logger log = Logger.getLogger(LOG_NAME);

        // 为log设置全局等级
        log.setLevel(Level.ALL);


        // 设置不适用父类的handlers，这样不会在控制台重复输出信息
        log.setUseParentHandlers(false);

        return log;
    }

    public static Logger getGlobalLog() {
        return globalLog;
    }

}


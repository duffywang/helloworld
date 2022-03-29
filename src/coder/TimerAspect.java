package src.coder;


/**
 * @auther : wangyufei
 * @date : 2021-05-10
 **/
//@Aspect
//public class TimerAspect {
//
//    @Pointcut("execution(* com.dianping.weixinbiz.remote.impl.*(..))")
//    void timer() {
//
//    }
//
//    @Around("timer()")
//    public Object logTimer(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        MonitorTime monitorTime = new MonitorTime();
//        String className = proceedingJoinPoint.getTarget().getClass().getName();
//        String methodName = proceedingJoinPoint.getSignature().getName();
//        monitorTime.setClassName(className);
//        monitorTime.setMethodName(methodName);
//        monitorTime.setLogTime(new Date());
//
//        long start = System.currentTimeMillis();
//        Object result = proceedingJoinPoint.proceed();
//        long time = System.currentTimeMillis() - start;
//        monitorTime.setConsumeTime(time);
//        return result;
//    }
//}

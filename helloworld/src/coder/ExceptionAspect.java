package coder;


/**
 * @auther : wangyufei
 * @date : 2021-05-10
 **/
//public class ExceptionAspect {
//    @Pointcut
//    void exceptionMethod(){
//
//    }
//
//    @Around
//    public Object monitorMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        try {
//            return proceedingJoinPoint.proceed();
//        } catch (Throwable e) {
//            ExceptionInfo exceptionInfo = new ExceptionInfo();
//            exceptionInfo.setClassName(proceedingJoinPoint.getTarget().getClass().getName());
//            exceptionInfo.setMethodName(proceedingJoinPoint.getSignature().getName());
//            exceptionInfo.setLogTime(new Date());
//
//            exceptionInfo.setMessage(e.toString());
//            return null;
//        }
//    }
//}

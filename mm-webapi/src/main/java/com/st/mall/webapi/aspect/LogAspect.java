package com.st.mall.webapi.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author bobo.
 * @date 11/27/2017
 * @email ruantianbo@163.com
 */
@Component
@Aspect
public class LogAspect extends AbstractAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

//    private void print(HttpServletRequest request) {
//        printParam(request);
//        printHeader(request);
//    }
//
//    //~============help=========
//    private void printHeader(HttpServletRequest request) {
//        Enumeration<String> headerNames = request.getHeaderNames();
//        StringBuilder sb = new StringBuilder("\r\n");
//        if (headerNames.hasMoreElements()) {
//            sb.append("\r\n=============println header start==============");
//            while (headerNames.hasMoreElements()) {
//                String nextElement = headerNames.nextElement();
//                sb.append("\r\n").append(nextElement).append(" : ").append(request.getHeader(nextElement));
//            }
//            sb.append("\r\n=============println header end==============");
//        }
//        logger.info(sb.toString());
//    }
//
//    private void printParam(HttpServletRequest request) {
//        Enumeration<String> paramNames = request.getParameterNames();
//        StringBuilder sb = new StringBuilder("\r\n");
//        if (paramNames.hasMoreElements()) {
//            if (paramNames.hasMoreElements()) {
//                sb.append("=============println param start==============");
//                while (paramNames.hasMoreElements()) {
//                    String nextElement = paramNames.nextElement();
//                    sb.append(nextElement).append(" : ").append(request.getParameter(nextElement));
//                }
//                sb.append("=============println param end==============");
//            }
//        }
//        logger.info(sb.toString());
//
//    }
//
//    @Before("accessLog()")
//    public void logBefore(JoinPoint joinPoint) {
//        HttpServletRequest request = getServletRequest();
//        print(request);
//        String sb = "\r\n=============println aspect log start==============" +
//                "\r\nprocess-class : " + joinPoint.getSignature().getDeclaringTypeName() +
//                "\r\nprocess-method : " + joinPoint.getSignature().getName() +
//                "\r\nrequest-method : " + request.getMethod() +
//                "\r\nprocess-method-args : " + Arrays.toString(joinPoint.getArgs()) +
//                "\r\n=============println aspect log end==============";
//        logger.info(sb);
//    }
//
//    @Around("doInsert()")
//    public void validUnique(ProceedingJoinPoint jp){
//        logger.debug("Do validate Insert");
//        HttpServletRequest httpServletRequest = getServletRequest();
//        Object[] args = jp.getArgs();
//        try{
//            Object o = jp.proceed(args);
//        }catch (Throwable ex){
//            logger.debug("",ex);
//        }
//    }
}
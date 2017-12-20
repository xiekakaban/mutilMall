package com.st.mall.webapi.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author bobo.
 * @date 12/1/2017
 * @email ruantianbo@163.com
 */
@Aspect
@Component
public class DBAspect extends AbstractAspect{
    Logger logger = LoggerFactory.getLogger(DBAspect.class);
//
//
//    @Before("accessLog()")
//    public void uni(JoinPoint joinPoint){
//        logger.debug("Hello w");
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

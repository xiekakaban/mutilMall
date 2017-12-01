package com.st.webapi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bobo.
 * @date 12/1/2017
 * @email ruantianbo@163.com
 */
@Aspect
@Component
public class DBAspect extends AbstractAspect{
    Logger logger = LoggerFactory.getLogger(DBAspect.class);


    @Before("doInsert()")
    public void uni(JoinPoint joinPoint){
        logger.debug("Hellow");
    }

    @Around("doInsert()")
    public void validUnique(ProceedingJoinPoint jp){
        logger.debug("Do validate Insert");
        HttpServletRequest httpServletRequest = getServletRequest();
        Object[] args = jp.getArgs();
        try{
            Object o = jp.proceed(args);
        }catch (Throwable ex){
            logger.debug("",ex);
        }
    }

}

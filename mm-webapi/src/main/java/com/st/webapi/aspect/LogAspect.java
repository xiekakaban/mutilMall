package com.st.webapi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bobo.
 * @date 11/27/2017
 * @email ruantianbo@163.com
 */
@Component
@Aspect
public class LogAspect extends AbstractAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("accessLog()")
    public void logBefore(JoinPoint joinPoint) {
        HttpServletRequest request = getServletRequest();

        StringBuffer sb = new StringBuffer();
        sb.append("url: " + request.getRequestURL()).append("\t");
        sb.append("method: " + request.getMethod()).append("\t");
        sb.append("ip: " + request.getRemoteAddr()).append("\t");
        //类方法
        sb.append("class: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()).append("\t");
        ;
        //参数
        sb.append("args: " + joinPoint.getArgs()).append("\n");
        logger.info(sb.toString());
    }


}
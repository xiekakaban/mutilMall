package com.st.webapi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

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

        String sb = ("url: " + request.getRequestURL()) + "\t" +
                "method: " + request.getMethod() + "\t" +
                "ip: " + request.getRemoteAddr() + "\t" +
                "class: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "\t" +
                "args: " + Arrays.toString(joinPoint.getArgs()) + "\n";
        logger.info(sb);
    }


}
package com.st.webapi.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bobo.
 * @date 11/27/2017
 * @email ruantianbo@163.com
 */
public abstract class AbstractAspect {

    /**
     * record every user visit
     */
    @Pointcut("execution(public * com.st.webapi.controller.*.*(..))")
    public void accessLog() {
    }

    /**
     * User Login check
     */
    @Pointcut("execution(public * com.st.webapi.controller.*.*(..)) && @annotation(com.st.webapi.annotation.AuthorCheckAnnotation)")
    public void loginCheck() {
    }

    /**
     * Get Request
     */
    protected HttpServletRequest getServletRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }
}
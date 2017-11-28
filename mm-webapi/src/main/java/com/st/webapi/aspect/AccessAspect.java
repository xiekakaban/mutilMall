package com.st.webapi.aspect;

import com.st.webapi.annotation.AuthorCheckAnnotation;
import com.st.webapi.aspect.AbstractAspect;
import com.st.webapi.util.Constants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author bobo.
 * @date 11/27/2017
 * @email ruantianbo@163.com
 */
@Component
@Aspect
public class AccessAspect extends AbstractAspect {

    @Before("loginCheck()")
    public void adminLoginCheckBefore(JoinPoint joinPoint) throws NoPermissionException {

        HttpServletRequest request = getServletRequest();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        AuthorCheckAnnotation adminAuthorCheckAnnotation = method.getAnnotation(AuthorCheckAnnotation.class);
        //will check authorization
        if (adminAuthorCheckAnnotation != null && adminAuthorCheckAnnotation.value()) {
            if (request.getSession().getAttribute(Constants.SESS_USER) == null) {
                throw new NoPermissionException();
            }
        } else {
            adminAuthorCheckAnnotation = method.getDeclaringClass().getAnnotation(AuthorCheckAnnotation.class);
            if (adminAuthorCheckAnnotation != null && adminAuthorCheckAnnotation.value()) {
                if (request.getSession().getAttribute(Constants.SESS_USER) == null) {
                    throw new NoPermissionException();
                }
            }
        }
    }
}

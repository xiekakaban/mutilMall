package com.st.mall.webapi.aspect;

import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

/**
 * @author bobo.
 * @date 11/27/2017
 * @email ruantianbo@163.com
 */
@Component
@Aspect
public class AccessAspect extends AbstractAspect {



//    @Before("loginCheck()")
//    public void adminLoginCheckBefore(JoinPoint joinPoint) throws NoPermissionException {
//
//        HttpServletRequest request = getServletRequest();
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        AuthorCheckAnnotation adminAuthorCheckAnnotation = method.getAnnotation(AuthorCheckAnnotation.class);
//        //will check authorization
//        if (adminAuthorCheckAnnotation != null && adminAuthorCheckAnnotation.value()) {
//            if (request.getSession().getAttribute(Constants.SESS_USER) == null) {
//                throw new NoPermissionException();
//            }
//        } else {
//            adminAuthorCheckAnnotation = method.getDeclaringClass().getAnnotation(AuthorCheckAnnotation.class);
//            if (adminAuthorCheckAnnotation != null && adminAuthorCheckAnnotation.value()) {
//                if (request.getSession().getAttribute(Constants.SESS_USER) == null) {
//                    throw new NoPermissionException();
//                }
//            }
//        }
//    }
}

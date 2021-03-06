package com.st.mall.webapi.annotation;

import java.lang.annotation.*;

/**
 * @author bobo.
 * @date 11/27/2017
 * @email ruantianbo@163.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface AuthorCheckAnnotation {
    // weather or not should process
    boolean value() default true;
}

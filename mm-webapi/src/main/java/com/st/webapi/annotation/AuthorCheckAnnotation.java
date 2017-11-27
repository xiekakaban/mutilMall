package com.st.webapi.annotation;

import java.lang.annotation.*;

/**
 * Created by tianbo on 11/27/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface AuthorCheckAnnotation {
    // 是否进行权限检查
    boolean value() default false;
}

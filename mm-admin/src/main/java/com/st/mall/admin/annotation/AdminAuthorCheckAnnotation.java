package com.st.mall.admin.annotation;

import java.lang.annotation.*;

/**
 * @author bobo.
 * @date 11/27/2017
 * @email ruantianbo@163.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface AdminAuthorCheckAnnotation {
    // 是否进行权限检查
    boolean value() default false;
}


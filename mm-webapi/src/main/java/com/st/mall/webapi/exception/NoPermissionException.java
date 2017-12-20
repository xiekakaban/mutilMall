package com.st.mall.webapi.exception;

/**
 * @author bobo.
 * @date 11/28/2017
 * @email ruantianbo@163.com
 */
public class NoPermissionException extends RuntimeException{
    public NoPermissionException(){
        super("No Authority,You need login First");
    }
}

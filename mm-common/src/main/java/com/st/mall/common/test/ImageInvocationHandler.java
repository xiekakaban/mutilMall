package com.st.mall.common.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author bobo.
 * @date 12/15/2017
 * @email ruantianbo@163.com
 */
public class ImageInvocationHandler implements InvocationHandler {
    String filename;
    public ImageInvocationHandler(String filename){
        this.filename = filename;
    }
    InterfaceImage img;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(this.img == null){
            this.img = new RealImage(filename);
            System.out.println("init RealImage");
        }
        if(method.getName().equalsIgnoreCase("showImage")){
            img.showImage();
        }
        return null;
    }
}

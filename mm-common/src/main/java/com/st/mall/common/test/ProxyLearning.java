package com.st.mall.common.test;

import java.lang.reflect.Proxy;

/**
 * @author bobo.
 * @date 12/15/2017
 * @email ruantianbo@163.com
 */
public class ProxyLearning {
    public static void main(String[] args){
        InterfaceImage interfaceImage = (InterfaceImage)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{InterfaceImage.class},new ImageInvocationHandler("1.txt"));
        interfaceImage.showImage();
    }
}

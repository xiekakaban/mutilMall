package com.st.mall.common.test;

/**
 * @author bobo.
 * @date 12/15/2017
 * @email ruantianbo@163.com
 */
public class RealImage implements InterfaceImage {
    String filename;
    public RealImage(String filename) {
        this.filename = filename;
        System.out.println("init now");
    }

    @Override
    public void showImage() {
        try {
            System.out.println("*****读取文件:"+filename+"******");
            Thread.sleep(1000);
            System.out.println("*****读取完成******");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("文件读取有点问题！");
        }
    }
}

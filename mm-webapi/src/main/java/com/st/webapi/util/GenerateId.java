package com.st.webapi.util;

import java.util.UUID;

/**
 * @author bobo.
 * @date 11/27/2017
 * @email ruantianbo@163.com
 */
public class GenerateId {
    public static String generate(){
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey.toString();
    }
    public static void main(String[] args){
        System.out.println(generate());
    }
}

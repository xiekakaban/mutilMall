package com.statestr.mall.util;

/**
 * Created by e604845 on 8/12/2017.
 */
import java.util.UUID;

public class GenerateId {
    public static String generate(){
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey.toString();
    }
    public static void main(String[] args){
        System.out.println(generate());
    }
}

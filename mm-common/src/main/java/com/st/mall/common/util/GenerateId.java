package com.st.mall.common.util;

import org.springframework.util.StringUtils;

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

    public static String generate(String prefix,String suffix){
        StringBuilder sb = new StringBuilder();
        if(!StringUtils.isEmpty(prefix)){
            sb.append(prefix);
        }
        sb.append(generate());
        if(!StringUtils.isEmpty(suffix)){
            sb.append(suffix);
        }
        return sb.toString();
    }
}

package com.st.common.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by e604845 on 11/14/2017.
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.binux.mapper")
public class CommonTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonTestApplication.class, args);
    }
}

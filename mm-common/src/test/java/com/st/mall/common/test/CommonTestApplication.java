package com.st.mall.common.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by e604845 on 11/14/2017.
 */
@SpringBootApplication(scanBasePackages = "com.st.mall" )
@MapperScan(basePackages = "com.st.mall.common.mapper")
public class CommonTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonTestApplication.class, args);
    }
}

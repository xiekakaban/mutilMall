package com.st.mall.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author bobo.
 * @date 12/27/2017
 * @email ruantianbo@163.com
 */
@SpringBootApplication
@ComponentScan("com.st")
@MapperScan(basePackages = "com.st.mall.dao.customized")
@PropertySources({
    @PropertySource(value = "classpath:application-ooc-test.properties"),
    @PropertySource(ignoreResourceNotFound = true, value = "classpath:application-ooc-dao.properties")
})
public class SprintTestApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Start run test application");
    }

    public static void main(String[] args) {
        SpringApplication.run(SprintTestApplication.class, args);
    }
}

package com.st.mall.webapi;

import com.st.mall.webapi.config.CustomJacksonObjectMapper;
import com.st.mall.webapi.util.MMLoger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * @author liuzh
 * @since 2015-12-12 18:22
 */
@Controller
@SpringBootApplication
@ComponentScan("com.st")
@MapperScan(basePackages = "com.st.mall.dao.customized")
@Configuration
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application-dao.properties")
//CommandLineRunner、ApplicationRunner 接口是在容器启动成功后的最后一步回调
//WebMvcConfigurerAdapter 是 SpringBoot内部提供专门处理用户自行添加的配置，里面包含了修改视图的过滤，拦截器，过滤器，Cors配置等。
public class    Application extends WebMvcConfigurerAdapter implements CommandLineRunner {

    @Autowired
    private MessageSource messageSource;

    private MMLoger logger = MMLoger.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("ASDW");
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.CHINA);
        return sessionLocaleResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        CustomJacksonObjectMapper mapper = new CustomJacksonObjectMapper();
        converter.setObjectMapper(mapper);
        return converter;
    }

}

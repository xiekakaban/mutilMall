package com.st.webapi;

import com.samskivert.mustache.Mustache;
import com.st.webapi.util.MMLoger;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
@MapperScan(basePackages = "com.st.dao.customized")
@Configuration
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application-dao.properties")
//CommandLineRunner、ApplicationRunner 接口是在容器启动成功后的最后一步回调
//WebMvcConfigurerAdapter 是 SpringBoot内部提供专门处理用户自行添加的配置，里面包含了修改视图的过滤，拦截器，过滤器，Cors配置等。
public class Application extends WebMvcConfigurerAdapter implements CommandLineRunner {

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

    //    @RequestMapping("/welcome")
//    public String home() {
//        return "welcome";
//    }

    // 配置mustache default value.
//    @Bean
//    public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader mustacheTemplateLoader,
//                                              Environment environment){
//        MustacheEnvironmentCollector collector = new MustacheEnvironmentCollector();
//        collector.setEnvironment(environment);
//        // default value
//        Mustache.Compiler compiler = Mustache.compiler().defaultValue("null")
//                .withLoader(mustacheTemplateLoader)
//                .withCollector(collector);
//        return compiler;
//    }

//    @Bean
//    public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}

package com.st.mall.webapi.config;

import com.st.mall.service.AuthenticationValidateProvider;
import com.st.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author bobo.
 * @date 12/26/2017
 * @email ruantianbo@163.com
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationValidateProvider authenticationValidateProvider;


        @Override
    public void configure(HttpSecurity http) throws Exception {

         http
             .authorizeRequests().anyRequest().permitAll().and()
                 .csrf().disable()
            .formLogin().and()
                 .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //静态资源不做处理
        web.ignoring().antMatchers("/resources/**");
    }



    @Override
    protected void configure(AuthenticationManagerBuilder  auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("password").roles("USERS")
//        .and().withUser("xiekakaban").password("123456").roles("USERS","ADMIN")
//        .and().withUser("tianyeling").password("123456").roles("USERS");
        //UserDetailsService
//        auth.userDetailsService(userService);
        //AuthenticationProvider
        auth.authenticationProvider(authenticationValidateProvider);


    }


}

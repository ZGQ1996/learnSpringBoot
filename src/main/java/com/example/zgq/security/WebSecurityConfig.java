package com.example.zgq.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 18:43 2019/3/9
 * @ Description：security配置类
 * @ Modified By：
 * @Version: $
 */

@Configuration
//开启security安全框架
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public CustomuserService customuserService(){
        return new CustomuserService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //路由策略和访问权限的简单配置
        http
                .formLogin()                      //启用默认登陆页面
                .failureUrl("/login?error")     //登陆失败返回URL:/login?error
                .defaultSuccessUrl("/hello/jump")  //登陆成功跳转URL，这里调整到用户首页
                .permitAll();                    //登陆页面全部权限可访问
        super.configure(http);
    }
    /**
     * 配置内存用户
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth
            .userDetailsService(customuserService());
//            .inMemoryAuthentication()
//            .withUser("周国庆").password("1996").roles("ADMIN")
//            .and()
//            .withUser("阿吉").password("123").roles("USER");
    }

}

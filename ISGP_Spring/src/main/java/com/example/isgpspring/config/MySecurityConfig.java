package com.example.isgpspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;


@EnableWebSecurity
public class MySecurityConfig {
    @Configuration
    @Order(2)
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
            //授权规则
            http.authorizeRequests()
                    .antMatchers("/ISGP/").hasRole("VIP")
                    .and()
                    .csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
                @Override
                public boolean matches(HttpServletRequest httpServletRequest) {
                    String servletPath = httpServletRequest.getServletPath();
                    return !servletPath.contains("/ISGP");
                }
            });
            //开启自动登录
            http.formLogin();
            http.logout();
            http.rememberMe();
        }

        //认证规则
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
            auth.inMemoryAuthentication().withUser("admin").password("123456").roles("VIP");

        }
    }
    @Configuration
    @Order(1)
    public class SecurityConfigTwo extends WebSecurityConfigurerAdapter{
        @Override
        protected  void configure(HttpSecurity http) throws Exception{
            http.authorizeRequests()
                    .antMatchers("/swagger-ui.html").permitAll()
                    .antMatchers("/druid").permitAll()
                    .and()
                    .csrf().disable();
            //开启自动登录
            http.formLogin();
            http.logout();
            http.rememberMe();
        }
    }
}

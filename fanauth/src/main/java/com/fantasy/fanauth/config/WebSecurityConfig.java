package com.fantasy.fanauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author: xiangming
 * @date: 2020/03/20 15:23
 * @describetion: 安全策略配置
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private DbUserDetailsService dbUserDetailsService;

    @Autowired
    public void setAnyUserDetailsService(DbUserDetailsService dbUserDetailsService){
        this.dbUserDetailsService = dbUserDetailsService;
    }
    /**
     * 匹配 "/" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
     * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
     * 默认启用 CSRF
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/user/**").hasRole("USER")
                    .and()
                    .formLogin().loginPage("/login").defaultSuccessUrl("/user")
                    .and()
                    .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
        httpSecurity.addFilterAt(customFromLoginFilter(), UsernamePasswordAuthenticationFilter.class);


    }


//    @Override
////    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
////        authenticationManagerBuilder.userDetailsService(dbUserDetailsService);
////    }
////
////    @Bean
////    public static PasswordEncoder passwordEncoder() {
////        return NoOpPasswordEncoder.getInstance();
////    }
    /**
     * 自定义认证过滤器
     */
    private CustomFromLoginFilter customFromLoginFilter() {
        return new CustomFromLoginFilter("/login");
    }

}

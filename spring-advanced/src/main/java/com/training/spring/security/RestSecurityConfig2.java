package com.training.spring.security;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
@Order(1)
public class RestSecurityConfig2 extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(final HttpSecurity httpParam) throws Exception {
        httpParam.antMatcher("/actuator/**")
                 .authorizeRequests()
                 .antMatchers("/actuator/**")
                 .permitAll()
                 .and()
                 .httpBasic()
                 .and()
                 .formLogin()
                 .disable()
                 .cors()
                 .disable()
                 .csrf()
                 .disable();
    }

}

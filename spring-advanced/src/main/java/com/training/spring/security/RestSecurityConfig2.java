package com.training.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class RestSecurityConfig2 extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(final HttpSecurity httpParam) throws Exception {
        httpParam.antMatcher("/actuator/**")
                 .authorizeRequests()
                 .antMatchers("/actuator/**")
                 .hasAnyRole("ADMIN")
                 .and()
                 .formLogin()
                 .and()
                 .httpBasic()
                 .disable()
                 .cors()
                 .disable()
                 .csrf()
                 .disable();
    }

}

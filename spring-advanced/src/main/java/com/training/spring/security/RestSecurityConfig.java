package com.training.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Order(2)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService   muds;

    @Autowired
    private BCryptPasswordEncoder bcpe;

    @Override
    protected void configure(final AuthenticationManagerBuilder authParam) throws Exception {
        authParam.userDetailsService(this.muds)
                 .passwordEncoder(this.bcpe);
    }

    @Override
    protected void configure(final HttpSecurity httpParam) throws Exception {
        httpParam.antMatcher("/**")
                 .authorizeRequests()
                 .antMatchers("/sec/xyz/**")
                 .hasAnyRole("ADMIN")
                 .antMatchers("/sec/abc/**")
                 .hasAnyRole("USER",
                             "ADMIN",
                             "VIEW")
                 .anyRequest()
                 .authenticated()
                 .and()
                 .sessionManagement()
                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
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

package com.training.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Order(2)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService   muds;

    @Autowired
    private BCryptPasswordEncoder bcpe;

    @Autowired
    private JWTRequestFilter      jwtFilter;

    @Autowired
    private MySecurityEntryPoint  myse;

    @Override
    protected void configure(final AuthenticationManagerBuilder authParam) throws Exception {
        authParam.userDetailsService(this.muds)
                 .passwordEncoder(this.bcpe);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final HttpSecurity httpParam) throws Exception {
        httpParam.antMatcher("/**")
                 .authorizeRequests()
                 .antMatchers("/token/**")
                 .permitAll()
                 .antMatchers("/actuator/**")
                 .permitAll()
                 .antMatchers("/sec/xyz/**")
                 .hasAnyRole("ADMIN")
                 .antMatchers("/sec/abc/**")
                 .hasAnyRole("USER",
                             "ADMIN",
                             "VIEW")
                 .antMatchers("/api/v1/user/provison/**")
                 .hasAnyRole("ADMIN")
                 .anyRequest()
                 .authenticated()
                 .and()
                 .exceptionHandling()
                 .authenticationEntryPoint(this.myse)
                 .and()
                 .sessionManagement()
                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                 .and()
                 .httpBasic()
                 .disable()
                 .formLogin()
                 .disable()
                 .cors()
                 .disable()
                 .csrf()
                 .disable();
        httpParam.addFilterBefore(this.jwtFilter,
                                  UsernamePasswordAuthenticationFilter.class);
    }

}

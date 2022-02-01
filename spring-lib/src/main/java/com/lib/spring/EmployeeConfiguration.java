package com.lib.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {

    @Bean
    public EmployeeCache employeeCache() {
        return new EmployeeCache();
    }

}

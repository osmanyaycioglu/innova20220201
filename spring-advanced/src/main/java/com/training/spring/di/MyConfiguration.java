package com.training.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.innova.spring.CounterBean;

//@Service
//@Controller
//@Repository
@Configuration
public class MyConfiguration {

    @Bean(name = "countMe")
    @Qualifier("counterTest1")
    public CounterBean counterBean() {
        CounterBean counterBeanLoc = new CounterBean();
        counterBeanLoc.increamentAndGet();
        counterBeanLoc.increamentAndGet();
        return counterBeanLoc;
    }

    @Bean(name = "countMe2")
    @RealCounter
    public CounterBean counterBean2() {
        CounterBean counterBeanLoc = new CounterBean();
        counterBeanLoc.increamentAndGet();
        counterBeanLoc.increamentAndGet();
        counterBeanLoc.increamentAndGet();
        counterBeanLoc.increamentAndGet();
        counterBeanLoc.increamentAndGet();
        counterBeanLoc.increamentAndGet();
        return counterBeanLoc;
    }

}

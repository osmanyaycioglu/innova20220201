package com.training.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class CallMe {

    public String hello(final String name) {
        System.out.println("Hello nun içi");
        return "Hello " + name;
    }

}

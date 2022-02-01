package com.training.spring.di;

import org.springframework.stereotype.Component;

@Component
public class GreetingBean {

    public void greet(final String name) {
        System.out.println("Hello " + name);
    }

}

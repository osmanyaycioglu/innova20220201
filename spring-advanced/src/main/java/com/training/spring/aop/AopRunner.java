package com.training.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AopRunner implements CommandLineRunner {

    @Autowired
    private CallOther co;

    @Override
    public void run(final String... argsParam) throws Exception {
        System.out.println("------------AOP-----------------------");
        System.out.println(this.co.sayHello());
        System.out.println("------------!AOP-----------------------");

    }

}

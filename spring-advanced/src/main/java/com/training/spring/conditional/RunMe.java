package com.training.spring.conditional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunMe implements CommandLineRunner {

    @Autowired
    private IHello hello;

    @Override
    public void run(final String... argsParam) throws Exception {
        System.out.println("Hello interface returned : " + this.hello.hello());
    }

}

package com.training.spring.conditional;

import org.springframework.stereotype.Component;

@Component
@CheckEnv(key = "app.lang", value = "eng")
public class EnglishHello implements IHello {

    @Override
    public String hello() {
        return "Hello";
    }

}

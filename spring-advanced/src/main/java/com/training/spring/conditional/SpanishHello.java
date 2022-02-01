package com.training.spring.conditional;

import org.springframework.stereotype.Component;

@Component
@CheckEnv(key = "app.lang", value = "esp")
public class SpanishHello implements IHello {

    @Override
    public String hello() {
        return "ola";
    }

}

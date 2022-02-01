package com.training.spring.conditional;

import org.springframework.stereotype.Component;

@Component
@CheckEnv(key = "app.lang", value = "tr")
public class TurkishHello implements IHello {

    @Override
    public String hello() {
        return "Merhaba";
    }

}

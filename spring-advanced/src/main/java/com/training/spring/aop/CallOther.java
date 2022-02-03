package com.training.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CallOther {

    @Autowired
    private CallMe callMe;

    public String sayHello() {
        return this.callMe.hello("osman");
    }

}

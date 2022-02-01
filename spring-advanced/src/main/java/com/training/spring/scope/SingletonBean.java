package com.training.spring.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    @Autowired
    private PrototypeBean prototypeBean;

    public void counter() {
        this.prototypeBean.counter();
    }
}

package com.training.spring.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

    private int count;

    public void counter() {
        System.out.println(this.count++);
    }

}

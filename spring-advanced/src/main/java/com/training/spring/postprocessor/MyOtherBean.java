package com.training.spring.postprocessor;

import org.springframework.stereotype.Component;

@Component
@BeanProc
public class MyOtherBean {

    private String name;

    public void writeName() {
        System.out.println("Other bean name is : " + this.name);
    }

}

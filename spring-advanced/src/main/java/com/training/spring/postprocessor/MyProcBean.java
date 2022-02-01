package com.training.spring.postprocessor;

import org.springframework.stereotype.Component;

@Component
@BeanProc
public class MyProcBean {

    private String name;

    public void writeName() {
        System.out.println("My name is : " + this.name);
    }

}

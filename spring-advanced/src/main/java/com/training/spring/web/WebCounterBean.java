package com.training.spring.web;

import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
// @RequestScope
// @SessionScope
public class WebCounterBean {

    private long counter = 0;

    public void increase() {
        this.counter++;
    }

    public long getCounter() {
        return this.counter;
    }

    public void setCounter(final long counterParam) {
        this.counter = counterParam;
    }

}

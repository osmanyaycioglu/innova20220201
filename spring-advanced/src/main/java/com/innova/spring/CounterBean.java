package com.innova.spring;

import org.springframework.stereotype.Component;

@Component
public class CounterBean {

    private long counter;

    public void increamentAndGet() {
        this.counter++;
    }

    public long getCounter() {
        return this.counter;
    }

}

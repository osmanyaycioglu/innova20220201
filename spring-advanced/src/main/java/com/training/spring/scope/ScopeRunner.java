package com.training.spring.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ScopeRunner implements CommandLineRunner {

    @Autowired
    private PrototypeBean pb1;

    @Autowired
    private PrototypeBean pb2;

    @Autowired
    private PrototypeBean pb3;

    @Autowired
    private SingletonBean sb1;
    @Autowired
    private SingletonBean sb2;
    @Autowired
    private SingletonBean sb3;

    @Override
    public void run(final String... argsParam) throws Exception {
        this.sb1.counter();
        this.sb1.counter();
        this.sb2.counter();
        this.sb2.counter();
        this.sb3.counter();
        this.sb3.counter();

        //        this.pb1.counter();
        //        this.pb1.counter();
        //        this.pb2.counter();
        //        this.pb2.counter();
        //        this.pb3.counter();
        //        this.pb3.counter();
    }

}

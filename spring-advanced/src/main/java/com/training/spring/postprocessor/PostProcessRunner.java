package com.training.spring.postprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PostProcessRunner implements CommandLineRunner {

    @Autowired
    MyProcBean  mpb;

    @Autowired
    MyOtherBean mob;

    @Override
    public void run(final String... argsParam) throws Exception {
        this.mpb.writeName();
        this.mob.writeName();
    }

}

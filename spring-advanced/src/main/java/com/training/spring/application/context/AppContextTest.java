package com.training.spring.application.context;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.training.spring.postprocessor.BeanProc;

@Component
public class AppContextTest implements CommandLineRunner {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void run(final String... argsParam) throws Exception {
        Map<String, Object> beansWithAnnotationLoc = this.applicationContext.getBeansWithAnnotation(BeanProc.class);
        for (Entry<String, Object> entryLoc : beansWithAnnotationLoc.entrySet()) {
            System.out.println("bean name : "
                               + entryLoc.getKey()
                               + " bean class : "
                               + entryLoc.getValue()
                                         .getClass()
                                         .getName());

        }
    }

}

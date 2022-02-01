package com.training.spring.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PropertyRunner implements CommandLineRunner {

    @Autowired
    private AppProperties ap;

    @Value("${server.port}")
    private Integer       port;

    @Value("#{appProperties.name}")
    private String        appName;

    @Override
    public void run(final String... argsParam) throws Exception {
        System.out.println("Properties : " + this.ap);
        System.out.println("App name : " + this.appName + " port : " + this.port);
    }

}

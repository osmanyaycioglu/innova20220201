package com.training.spring.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.training.spring.conditional.IHello;

@Component
public class MyBean implements BeanNameAware, EnvironmentAware {

    @Autowired
    private IHello      hello;

    @Autowired
    private Environment env;

    public void sayHello() {
        System.out.println(this.hello.hello());
    }

    @PostConstruct
    public void init() {
        System.out.println("MyBean init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("MyBean destroy");
    }

    @Override
    public void setBeanName(final String nameParam) {
        System.out.println("Bean ismi : " + nameParam);
    }

    @Override
    public void setEnvironment(final Environment environmentParam) {

    }


}

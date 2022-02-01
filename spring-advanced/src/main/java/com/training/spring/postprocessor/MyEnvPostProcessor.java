package com.training.spring.postprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyEnvPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(final ConfigurableEnvironment environmentParam,
                                       final SpringApplication applicationParam) {
        MutablePropertySources propertySourcesLoc = environmentParam.getPropertySources();
    }

}

package com.training.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.lib.spring.Employee;
import com.lib.spring.formatters.IFormat;

@Component
@Profile("dev")
//@Primary
public class MyFormatter implements IFormat {

    @Value("${formatter.prefix}")
    private String prefix;

    @Override
    public String format(final Employee empParam) {
        return this.prefix + " dev " + empParam.getName();
    }

}

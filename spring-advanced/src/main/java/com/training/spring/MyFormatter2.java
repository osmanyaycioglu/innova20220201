package com.training.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.lib.spring.Employee;
import com.lib.spring.formatters.IFormat;

@Component
@Profile("live")
public class MyFormatter2 implements IFormat {

    @Value("${formatter.prefix}")
    private String prefix;

    @Override
    public String format(final Employee empParam) {
        return this.prefix + " live " + empParam.getName();
    }

}

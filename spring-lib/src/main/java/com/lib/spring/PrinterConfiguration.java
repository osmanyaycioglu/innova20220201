package com.lib.spring;

import java.lang.reflect.Constructor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.lib.spring.formatters.EFormatterTypes;
import com.lib.spring.formatters.FormatterConfigurations;
import com.lib.spring.formatters.FullEmployeeFormatter;
import com.lib.spring.formatters.IFormat;
import com.lib.spring.formatters.ISOEmployeeFormatter;
import com.lib.spring.formatters.StandartEmployeeFormatter;

@Configuration
public class PrinterConfiguration {


    @Bean
    public FormatterConfigurations formatterConfigurations() {
        return new FormatterConfigurations();
    }


    @Bean
    @Lazy
    public Printer printer(final IFormat formatParam) {
        return new Printer(formatParam);
    }

    @Bean
    public String printer2() {
        System.out.println("test");
        //        IFormat formatterLoc = this.formatter();
        //        IFormat formatterLoc2 = this.formatter();
        //        IFormat formatterLoc3 = this.formatter();
        return "test";
    }


    @Bean
    @Lazy
    // @Scope("prototype")
    @ConditionalOnMissingBean(IFormat.class)
    public IFormat formatter(final FormatterConfigurations configurationsParam) {
        System.out.println("formatter generation");
        EFormatterTypes formatterTypesLoc = configurationsParam.getFormatterTypes();
        switch (formatterTypesLoc) {
            case CUSTOM:
                String classNameLoc = configurationsParam.getClassName();
                if ((classNameLoc != null) && !classNameLoc.isEmpty()) {
                    try {
                        Class<?> forNameLoc = Class.forName(classNameLoc);
                        Constructor<?> constructorLoc = forNameLoc.getConstructor();
                        IFormat newInstanceLoc = (IFormat) constructorLoc.newInstance();
                        return newInstanceLoc;
                    } catch (Exception e) {
                        return new StandartEmployeeFormatter();
                    }
                }
                return null;
            case FULL:
                return new FullEmployeeFormatter();
            case ISO:
                return new ISOEmployeeFormatter();
            case STANDART:
            default:
                return new StandartEmployeeFormatter();
        }
    }
}

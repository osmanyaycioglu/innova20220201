package com.lib.spring.formatters;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.formatter")
public class FormatterConfigurations {

    private EFormatterTypes formatterTypes = EFormatterTypes.STANDART;
    private String          className;

    public EFormatterTypes getFormatterTypes() {
        return this.formatterTypes;
    }

    public void setFormatterTypes(final EFormatterTypes formatterTypesParam) {
        this.formatterTypes = formatterTypesParam;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(final String classNameParam) {
        this.className = classNameParam;
    }

}

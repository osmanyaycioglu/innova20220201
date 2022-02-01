package com.lib.spring;

import com.lib.spring.formatters.IFormat;

//@Service
//@Lazy
public class Printer {

    private final IFormat format;

    public Printer(final IFormat formatParam) {
        super();
        this.format = formatParam;
    }


    public void print(final Employee employeeParam) {
        String formatLoc = this.format.format(employeeParam);
        System.out.println(formatLoc);
    }

}

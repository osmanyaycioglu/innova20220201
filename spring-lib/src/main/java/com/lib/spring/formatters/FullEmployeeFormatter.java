package com.lib.spring.formatters;

import com.lib.spring.Employee;

public class FullEmployeeFormatter implements IFormat {

    @Override
    public String format(final Employee empParam) {
        return "Sayın "
               + empParam.getName()
               + " "
               + empParam.getSurname()
               + " birth : "
               + empParam.getBirthDate()
               + " height :"
               + empParam.getHeight();
    }

}

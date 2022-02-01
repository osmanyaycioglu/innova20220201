package com.lib.spring.formatters;

import com.lib.spring.Employee;

public class ISOEmployeeFormatter implements IFormat {

    @Override
    public String format(final Employee empParam) {
        return "Sayın haz " + empParam.getName() + " " + empParam.getSurname() + " birth : " + empParam.getBirthDate();
    }

}

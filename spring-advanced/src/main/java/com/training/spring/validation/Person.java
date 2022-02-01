package com.training.spring.validation;

import javax.validation.constraints.Size;

public class Person {

    @StartWith("n:")
    private String name;
    @Size(min = 2, max = 20)
    @StartWith("s:")
    private String surname;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }


}

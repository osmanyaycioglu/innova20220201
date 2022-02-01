package com.lib.spring;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Employee {

    @NotEmpty
    @Size(min = 5, max = 12, message = "{validatedValue} {min} ile {max} arasında olmalı")
    private String    username;
    @NotEmpty
    @Size(min = 2, max = 15, message = "{validatedValue} {min} ile {max} arasında olmalı")
    private String    name;
    private String    surname;
    @Positive
    @Max(300)
    @Min(80)
    private int       height;
    @Past
    @NotNull
    private LocalDate birthDate;

    public static Employee createEmployee() {
        return new Employee();
    }

    public String getName() {
        return this.name;
    }

    public Employee setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public Employee setSurname(final String surnameParam) {
        this.surname = surnameParam;
        return this;
    }

    public int getHeight() {
        return this.height;
    }

    public Employee setHeight(final int heightParam) {
        this.height = heightParam;
        return this;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public Employee setBirthDate(final LocalDate birthDateParam) {
        this.birthDate = birthDateParam;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public Employee setUsername(final String usernameParam) {
        this.username = usernameParam;
        return this;
    }


}

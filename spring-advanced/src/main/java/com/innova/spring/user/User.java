package com.innova.spring.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "kullanici")
public class User {

    @Id
    @GeneratedValue
    private Long      userId;
    @NotEmpty
    private String    username;
    @NotEmpty
    private String    password;
    private LocalDate createDate;
    private ERole     role;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(final LocalDate createDateParam) {
        this.createDate = createDateParam;
    }

    public ERole getRole() {
        return this.role;
    }

    public void setRole(final ERole roleParam) {
        this.role = roleParam;
    }


}

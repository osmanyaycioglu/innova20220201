package com.innova.spring.user.rest.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.innova.spring.user.ERole;

public class UserRest {

    @NotEmpty
    @Size(min = 5, max = 12)
    private String username;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
             message = "Password bir özel karater...")
    private String password;
    @NotNull
    private ERole  role;


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

    public ERole getRole() {
        return this.role;
    }

    public void setRole(final ERole roleParam) {
        this.role = roleParam;
    }


}

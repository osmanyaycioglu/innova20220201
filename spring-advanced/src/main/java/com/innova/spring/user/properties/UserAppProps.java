package com.innova.spring.user.properties;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.innova.spring.user.User;

@Component
@ConfigurationProperties("app.user")
@Validated
public class UserAppProps {

    @NotNull
    @Valid
    private User        defaultAdmin;
    private Integer     viewMaxUser = 10;
    private Set<String> filterUsers = new HashSet<>();


    public User getDefaultAdmin() {
        return this.defaultAdmin;
    }


    public void setDefaultAdmin(final User defaultAdminParam) {
        this.defaultAdmin = defaultAdminParam;
    }

    public Integer getViewMaxUser() {
        return this.viewMaxUser;
    }

    public void setViewMaxUser(final Integer viewMaxUserParam) {
        this.viewMaxUser = viewMaxUserParam;
    }


    public Set<String> getFilterUsers() {
        return this.filterUsers;
    }


    public void setFilterUsers(final Set<String> filterUsersParam) {
        this.filterUsers = filterUsersParam;
    }


}

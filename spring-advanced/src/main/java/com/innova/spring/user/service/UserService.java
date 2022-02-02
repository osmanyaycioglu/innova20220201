package com.innova.spring.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.spring.user.User;
import com.innova.spring.user.data.UserDataAccess;
import com.innova.spring.user.properties.UserAppProps;

@Service
public class UserService {

    @Autowired
    private UserAppProps   userProps;

    @Autowired
    private UserDataAccess userDataAccess;

    public void add(final User userParam) {
        this.userDataAccess.create(userParam);
    }

    public User getOneUser(final String username) {
        if (this.userProps.getFilterUsers()
                          .contains(username)) {
            return null;
        }
        return this.userDataAccess.getUserByUsername(username);
    }

    public List<User> getAll() {
        return this.userDataAccess.getAll()
                                  .stream()
                                  .filter(u -> !this.userProps.getFilterUsers()
                                                              .contains(u.getUsername()))
                                  .collect(Collectors.toList());
    }
}

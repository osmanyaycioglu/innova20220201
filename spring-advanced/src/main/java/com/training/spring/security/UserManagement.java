package com.training.spring.security;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.innova.spring.user.ERole;
import com.innova.spring.user.EncryptedString;
import com.innova.spring.user.User;

@Service
public class UserManagement {

    private final Map<String, User> usermap = new ConcurrentHashMap<>();


    public UserManagement() {
        User userLoc = new User();
        userLoc.setUsername(new EncryptedString("osmany"));
        userLoc.setPassword(new EncryptedString("1234"));
        userLoc.setRole(ERole.ADMIN);
        this.usermap.put(userLoc.getUsername()
                                .getClearStr(),
                         userLoc);
        userLoc = new User();
        userLoc.setUsername(new EncryptedString("aliveli"));
        userLoc.setPassword(new EncryptedString("1234"));
        userLoc.setRole(ERole.USER);
        this.usermap.put(userLoc.getUsername()
                                .getClearStr(),
                         userLoc);
    }

    public User getUser(final String user) {
        return this.usermap.get(user);
    }

}

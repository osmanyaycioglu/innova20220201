package com.innova.spring.user.mappings;

import java.util.ArrayList;
import java.util.List;

import com.innova.spring.user.User;
import com.innova.spring.user.rest.models.UserRest;

public class UserMapping {

    public static UserRest mapToUserRest(final User oneUserParam) {
        UserRest user = new UserRest();
        user.setUsername(oneUserParam.getUsername());
        user.setRole(oneUserParam.getRole());
        return user;
    }

    public static List<UserRest> mapToUserRestList(final List<User> usersParam) {
        List<UserRest> listLoc = new ArrayList<>();
        for (User userLoc : usersParam) {
            listLoc.add(mapToUserRest(userLoc));
        }
        return listLoc;
    }

    public static User mapToUser(final UserRest userParam) {
        User user = new User();
        user.setUsername(userParam.getUsername());
        user.setRole(userParam.getRole());
        user.setPassword(userParam.getPassword());
        return user;
    }

}

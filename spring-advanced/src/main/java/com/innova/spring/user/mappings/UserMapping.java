package com.innova.spring.user.mappings;

import java.util.ArrayList;
import java.util.List;

import com.innova.spring.user.EncryptedString;
import com.innova.spring.user.User;
import com.innova.spring.user.rest.models.UserRest;

public class UserMapping {

    public static UserRest mapToUserRest(final User oneUserParam) {
        UserRest user = new UserRest();
        user.setUsername(oneUserParam.getUsername()
                                     .getClearStr());
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
        EncryptedString encs = new EncryptedString();
        encs.setClearStr(userParam.getUsername());
        user.setUsername(encs);
        user.setRole(userParam.getRole());
        EncryptedString encsp = new EncryptedString();
        encsp.setClearStr(userParam.getPassword());
        user.setPassword(encsp);
        return user;
    }

}

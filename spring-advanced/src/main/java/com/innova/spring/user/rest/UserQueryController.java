package com.innova.spring.user.rest;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innova.spring.user.User;
import com.innova.spring.user.mappings.UserMapping;
import com.innova.spring.user.rest.models.UserRest;
import com.innova.spring.user.service.UserService;

@RestController
@RequestMapping("/api/v1/user/query")
@Validated
public class UserQueryController {

    @Autowired
    private UserService userService;

    @PostMapping("/get/one")
    public UserRest get(@NotEmpty @RequestParam("user") final String username) {
        User oneUserLoc = this.userService.getOneUser(username);
        return UserMapping.mapToUserRest(oneUserLoc);
    }

    @PostMapping("/get/all")
    public List<UserRest> getAll() {
        List<User> users = this.userService.getAll();
        return UserMapping.mapToUserRestList(users);
    }

}

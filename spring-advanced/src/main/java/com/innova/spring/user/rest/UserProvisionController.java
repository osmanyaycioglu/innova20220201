package com.innova.spring.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innova.spring.user.mappings.UserMapping;
import com.innova.spring.user.rest.models.UserRest;
import com.innova.spring.user.service.UserService;
import com.training.spring.aop.Logcu;

@RestController
@RequestMapping("/api/v1/user/provison")
public class UserProvisionController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @Logcu("INFO")
    public String add(@RequestBody final UserRest userParam) {
        this.userService.add(UserMapping.mapToUser(userParam));
        return "User " + userParam.getUsername() + " added.";
    }

}

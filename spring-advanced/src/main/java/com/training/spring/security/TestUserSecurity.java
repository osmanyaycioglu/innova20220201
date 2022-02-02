package com.training.spring.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sec/abc/test")
public class TestUserSecurity {

    @GetMapping("/t1")
    public String t1() {
        return "User OK";
    }

    @PostMapping("/t2")
    public String t2() {
        return "User OK";
    }

}

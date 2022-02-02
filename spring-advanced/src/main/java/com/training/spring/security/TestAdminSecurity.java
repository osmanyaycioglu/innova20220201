package com.training.spring.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sec/xyz/test")
public class TestAdminSecurity {

    @GetMapping("/t1")
    public String t1() {
        return "Admin OK";
    }

    @PostMapping("/t2")
    public String t2() {
        return "Admin OK";
    }

}

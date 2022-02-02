package com.training.spring.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sec/method/test")
public class TestProgramSecurity {

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/t1")
    public String t1() {
        return "Admin OK";
    }

    // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/t2")
    public String t2() {
        return "User OK";
    }

    @PostMapping("/t3")
    public String t3() {
        return "User OK";
    }

}

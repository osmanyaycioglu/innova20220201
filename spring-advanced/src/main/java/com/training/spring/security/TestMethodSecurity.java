package com.training.spring.security;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sec/local/test")
public class TestMethodSecurity {

    @GetMapping("/t1")
    public String t1(final Principal principalParam) {
        if (principalParam instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken) principalParam;
            Object credentialsLoc = upat.getCredentials();
            Object detailsLoc = upat.getDetails();
            User principalLoc = (User) upat.getPrincipal();
            System.out.println("cred : " + credentialsLoc + " details : " + detailsLoc + " prin : " + principalLoc);
            Collection<GrantedAuthority> authoritiesLoc = principalLoc.getAuthorities();
            System.out.println(authoritiesLoc);
        }
        return "Admin OK";
    }

    @GetMapping("/t2")
    public String t2() {
        SecurityContext contextLoc = SecurityContextHolder.getContext();
        Authentication authenticationLoc = contextLoc.getAuthentication();
        UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken) authenticationLoc;
        Object credentialsLoc = upat.getCredentials();
        Object detailsLoc = upat.getDetails();
        User principalLoc = (User) upat.getPrincipal();
        System.out.println("cred : " + credentialsLoc + " details : " + detailsLoc + " prin : " + principalLoc);
        Collection<GrantedAuthority> authoritiesLoc = principalLoc.getAuthorities();
        System.out.println(authoritiesLoc);
        return "User OK";
    }

}

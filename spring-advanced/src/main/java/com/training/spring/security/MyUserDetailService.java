package com.training.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.innova.spring.user.User;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserManagement        um;

    @Autowired
    private BCryptPasswordEncoder bcpe;

    @Override
    public UserDetails loadUserByUsername(final String usernameParam) throws UsernameNotFoundException {
        User userLoc = this.um.getUser(usernameParam);
        if (userLoc == null) {
            throw new UsernameNotFoundException("Böyle bir user yok");
        }
        return org.springframework.security.core.userdetails.User.builder()
                                                                 .username(usernameParam)
                                                                 .password(this.bcpe.encode(userLoc.getPassword()))
                                                                 .roles(userLoc.getRole()
                                                                               .toString())
                                                                 .build();
    }

}

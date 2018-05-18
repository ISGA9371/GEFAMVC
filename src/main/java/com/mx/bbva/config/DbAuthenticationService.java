package com.mx.bbva.config;


import com.mx.bbva.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DbAuthenticationService implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userInternalId) throws UsernameNotFoundException {
        com.mx.bbva.business.entity.User user = userService.findUser(userInternalId);

        if (user == null) {
            throw new UsernameNotFoundException("User " + userInternalId + " was not found in the database");
        }

        GrantedAuthority authority = new SimpleGrantedAuthority("USER");

        return new User(user.getUserInternalId(), user.getUserPassword(), Collections.singletonList(authority));
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
package com.stefanmilojevic.myRealEstate.config;

import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userService.getByEmail(email);
        if(user == null) {
            throw new BadCredentialsException("Authentication failed");
        }
        if(userService.comparePasswords(password,user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(email, password, Collections.emptyList());
        }
        else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}

package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.service.UserService;
import com.stefanmilojevic.myRealEstate.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.ok(userService.createUser(user));
    }

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        User userCheck = userService.getByEmail(user.getEmail());
        if (userCheck != null) {
            return passwordEncoder.matches(user.getPassword(), userCheck.getPassword());
        } else return false;
    }

    @GetMapping("/getLoggedUser")
    public ResponseEntity<User> getLoggedUser(HttpServletRequest request){
        String email = UserUtil.getEmailFromRequest(request);
        System.out.println(email);
        return ResponseEntity.ok(userService.getByEmail(email));
    }


}

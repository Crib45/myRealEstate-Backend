package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.User;

public interface UserService {
    String createUser(User user);
    User getByEmail(String username);
    boolean comparePasswords(String password, String passwordTwo);
}

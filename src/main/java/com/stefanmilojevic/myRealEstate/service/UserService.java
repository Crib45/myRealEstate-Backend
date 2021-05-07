package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.User;

public interface UserService {
    String createUser(User user);
    User getByEmail(String email);
    boolean comparePasswords(String password, String passwordTwo);
}

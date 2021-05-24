package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private CityService cityService;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public  void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
        return "Success";
    }

    @Override
    public User getByEmail(String email) {
        User user = userRepository.getByEmail(email);
        user.setCity(cityService.getByUser(user));
        return userRepository.getByEmail(email);
    }

    @Override
    public boolean comparePasswords(String password, String passwordTwo) {
        return passwordEncoder.matches(password,passwordTwo);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String save(User user) {
        if(user.getId() != null){
            User oldUser = userRepository.getOne(user.getId());
            if(oldUser.getPicture() != null) {
                user.setPicture(oldUser.getPicture());
            }
        }
        userRepository.save(user);
        return "Success";
    }
}

package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        userRepository.save(user);
        return null;
    }

    @Override
    public User getByEmail(String username) {
        User user = userRepository.getByEmail(username);
        user.setCity(cityService.getByUser(user));
        return userRepository.getByEmail(username);
    }

    @Override
    public boolean comparePasswords(String password, String passwordTwo) {
        return passwordEncoder.matches(password,passwordTwo);
    }
}

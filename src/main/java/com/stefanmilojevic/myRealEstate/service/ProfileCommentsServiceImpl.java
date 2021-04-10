package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.repository.ProfileCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileCommentsServiceImpl implements ProfileCommentsService {

    private final ProfileCommentsRepository profileCommentsRepository;

    @Autowired
    public ProfileCommentsServiceImpl(ProfileCommentsRepository profileCommentsRepository) {
        this.profileCommentsRepository = profileCommentsRepository;
    }

}

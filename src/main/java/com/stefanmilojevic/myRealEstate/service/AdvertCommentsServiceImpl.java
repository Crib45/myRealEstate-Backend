package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.repository.AdvertCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertCommentsServiceImpl implements AdvertCommentsService {

    private final AdvertCommentsRepository advertCommentsRepository;

    @Autowired
    public AdvertCommentsServiceImpl(AdvertCommentsRepository advertCommentsRepository) {
        this.advertCommentsRepository = advertCommentsRepository;
    }
}

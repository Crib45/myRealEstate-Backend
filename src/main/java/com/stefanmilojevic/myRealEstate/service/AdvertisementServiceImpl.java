package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.Estate;
import com.stefanmilojevic.myRealEstate.repository.AdvertisementRepository;
import com.stefanmilojevic.myRealEstate.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final EstateRepository estateRepository;
    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository, EstateRepository estateRepository) {
        this.advertisementRepository = advertisementRepository;
        this.estateRepository = estateRepository;
    }


    @Override
    public Advertisement save(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
        return advertisement;
    }
}

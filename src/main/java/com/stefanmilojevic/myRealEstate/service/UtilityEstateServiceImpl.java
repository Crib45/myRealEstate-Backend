package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.repository.UtilityEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilityEstateServiceImpl {

    private final UtilityEstateRepository utilityEstateRepository;

    @Autowired
    public UtilityEstateServiceImpl(UtilityEstateRepository utilityEstateRepository) {
        this.utilityEstateRepository = utilityEstateRepository;
    }
}

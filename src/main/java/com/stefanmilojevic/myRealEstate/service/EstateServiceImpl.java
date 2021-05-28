package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Estate;
import com.stefanmilojevic.myRealEstate.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateServiceImpl implements EstateService {

    private final EstateRepository estateRepository;

    @Autowired
    public EstateServiceImpl(EstateRepository estateRepository) {
        this.estateRepository = estateRepository;
    }

    @Override
    public Estate findById(Long id) {
        return estateRepository.findById(id).orElse(null);
    }
}

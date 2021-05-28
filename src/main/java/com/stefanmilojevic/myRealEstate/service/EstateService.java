package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Estate;

public interface EstateService {
    Estate findById(Long id);
}

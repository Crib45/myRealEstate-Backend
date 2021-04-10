package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryServiceImpl {

    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    private SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }
}

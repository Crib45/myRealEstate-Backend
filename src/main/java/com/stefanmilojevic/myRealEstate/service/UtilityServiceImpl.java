package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.SubCategory;
import com.stefanmilojevic.myRealEstate.model.Utility;
import com.stefanmilojevic.myRealEstate.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilityServiceImpl implements UtilityService {

    private final UtilityRepository utilityRepository;
    private SubCategoryService subCategoryService;

    @Autowired
    private void setSubCategoryService(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @Autowired
    public UtilityServiceImpl(UtilityRepository utilityRepository) {
        this.utilityRepository = utilityRepository;
    }

    @Override
    public List<Utility> getAllByAdvertId(Long id) {
        SubCategory subCategory = subCategoryService.getByAdvertisementId(id);
        return utilityRepository.findAllBySubCategory(subCategory);
    }
}

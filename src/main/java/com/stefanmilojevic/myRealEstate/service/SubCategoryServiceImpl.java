package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Category;
import com.stefanmilojevic.myRealEstate.model.SubCategory;
import com.stefanmilojevic.myRealEstate.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryService categoryService;

    @Autowired
    private SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, CategoryService categoryService) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<SubCategory> getAllByCategoryTitle(String categoryTitle) {
        Category category = categoryService.getByTitle(categoryTitle);
        return subCategoryRepository.findAllByCategory(category);
    }
}

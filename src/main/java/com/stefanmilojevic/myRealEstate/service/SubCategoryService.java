package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.SubCategory;

import java.util.List;

public interface SubCategoryService {
     List<SubCategory> getAllByCategoryTitle(String categoryTitle);
     List<SubCategory> getAllByCategoryId(int categoryId);
}

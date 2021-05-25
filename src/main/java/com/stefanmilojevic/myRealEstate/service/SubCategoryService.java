package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.SubCategory;

import java.util.List;

public interface SubCategoryService {
     /**
      * Returns all <code>SubCategory</code> by category title
      * @param categoryTitle <code>String</code> representing Category title
      * @return List of <code>SubCategory</code>
      */
     List<SubCategory> getAllByCategoryTitle(String categoryTitle);

     /**
      * Returns all <code>SubCategory</code> by category title
      * @param categoryId <code>Int</code> representing Category id
      * @return List of <code>SubCategory</code>
      */
     List<SubCategory> getAllByCategoryId(int categoryId);

     SubCategory getByAdvertisementId(Long id);
}

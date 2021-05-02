package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getByTitle(String title);
    Category getById(int id);
}

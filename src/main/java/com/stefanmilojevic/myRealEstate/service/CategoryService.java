package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Category;

import java.util.List;

public interface CategoryService {
    /**
     * Returns list of all categories
     * @return <code>Category</code>
     */
    List<Category> getAll();

    /**
     * Returns Category with given title
     * @param title <code>String</code> name of title
     * @return found <code>Category</code>
     */
    Category getByTitle(String title);

    /**
     * Returns category by id
     * @param id <code>int</code> id of category
     * @return found <code>Category</code>
     */
    Category getById(int id);
}

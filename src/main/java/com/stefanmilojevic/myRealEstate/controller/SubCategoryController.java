package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.SubCategory;
import com.stefanmilojevic.myRealEstate.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/subcategory")
@RestController
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/getAllByCategoryTitle/{categoryTitle}")
        public ResponseEntity<List<SubCategory>> getAllByCategoryTitle(@PathVariable String categoryTitle) {
        return ResponseEntity.ok(subCategoryService.getAllByCategoryTitle(categoryTitle));
    }

    @GetMapping("/getAllByCategoryId/{categoryId}")
    public ResponseEntity<List<SubCategory>> getAllByCategoryTitle(@PathVariable int categoryId) {
        return ResponseEntity.ok(subCategoryService.getAllByCategoryId(categoryId));
    }
}

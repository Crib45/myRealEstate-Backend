package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.FavoriteAd;
import com.stefanmilojevic.myRealEstate.model.SavedFilter;
import com.stefanmilojevic.myRealEstate.service.SavedFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/savedFilters")
@RestController
public class SavedFilterController {

    private final SavedFilterService savedFilterService;

    @Autowired
    public SavedFilterController(SavedFilterService savedFilterService) {
        this.savedFilterService = savedFilterService;
    }

    @GetMapping("/getAllForLogged")
    public ResponseEntity<List<SavedFilter>> getByAdvertIdForLogged(HttpServletRequest request) {
        return ResponseEntity.ok(savedFilterService.getAllForLogged(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(savedFilterService.delete(id));
    }

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody SavedFilter savedFilter, HttpServletRequest request) {
        return ResponseEntity.ok(savedFilterService.save(savedFilter, request));
    }

}

package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.Utility;
import com.stefanmilojevic.myRealEstate.model.UtilityEstate;
import com.stefanmilojevic.myRealEstate.service.UtilityEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/utilityEstate")
@RestController
public class UtilityEstateController {

    private final UtilityEstateService utilityEstateService;

    @Autowired
    public UtilityEstateController(UtilityEstateService utilityEstateService) {
        this.utilityEstateService = utilityEstateService;
    }

    @GetMapping("/getAllByAdvertId/{advertId}")
    public ResponseEntity<List<UtilityEstate>> getAllByAdvertId(@PathVariable Long advertId){
        return ResponseEntity.ok(utilityEstateService.getAllByAdvertId(advertId));
    }

    @PostMapping("/saveAll")
    public ResponseEntity<String> saveAll(@RequestBody List<UtilityEstate> utilityEstateList) {
        return ResponseEntity.ok(utilityEstateService.saveAll(utilityEstateList));
    }
}

package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/advertisement")
@RestController
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping()
    public ResponseEntity<Advertisement> save(@RequestBody Advertisement advertisement, HttpServletRequest request) {
        return ResponseEntity.ok(advertisementService.save(advertisement, request));
    }

    @GetMapping("/getAllByLogged")
    public ResponseEntity<List<Advertisement>> getAllByLogged(HttpServletRequest request) {
        return ResponseEntity.ok(advertisementService.getAllByLogged(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return ResponseEntity.ok(advertisementService.delete(id));
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity<Advertisement> publish(@PathVariable int id) {
        return ResponseEntity.ok(advertisementService.publish(id));
    }

    @GetMapping("/getAllPublishedBySubCategoryId/{subcategoryId}")
    public ResponseEntity<List<Advertisement>> getAllPublishedBySubCategoryId(@PathVariable int subcategoryId) {
        return ResponseEntity.ok(advertisementService.getAllPublishedBySubCategoryId(subcategoryId));
    }
}

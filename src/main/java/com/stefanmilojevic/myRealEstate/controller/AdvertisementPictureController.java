package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.AdvertisementPicture;
import com.stefanmilojevic.myRealEstate.model.City;
import com.stefanmilojevic.myRealEstate.service.AdvertisementPictureService;
import com.stefanmilojevic.myRealEstate.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/advertisementPicture")
@RestController
public class AdvertisementPictureController {

    private final AdvertisementPictureService advertisementPictureService;

    @Autowired
    public AdvertisementPictureController(AdvertisementPictureService advertisementPictureService) {
        this.advertisementPictureService = advertisementPictureService;
    }

    @GetMapping("/getAllByAdvertisementId/{id}")
    public ResponseEntity<List<AdvertisementPicture>> getAllByAdvertisementId(@PathVariable int id) {
        return ResponseEntity.ok(advertisementPictureService.getAllByAdvertisementId(id));
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody AdvertisementPicture advertisementPicture) {
        return ResponseEntity.ok(advertisementPictureService.save(advertisementPicture));
    }
}

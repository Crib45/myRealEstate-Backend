package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.AdvertisementPicture;
import com.stefanmilojevic.myRealEstate.service.AdvertisementPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/advertisementPictures")
@RestController
public class AdvertisementPictureController {

    private final AdvertisementPictureService advertisementPictureService;

    @Autowired
    public AdvertisementPictureController(AdvertisementPictureService advertisementPictureService) {
        this.advertisementPictureService = advertisementPictureService;
    }

    @GetMapping("/getAllByAdvertisementId/{id}")
    public ResponseEntity<List<AdvertisementPicture>> getAllByAdvertisementId(@PathVariable Long id) {
        return ResponseEntity.ok(advertisementPictureService.getAllByAdvertisementId(id));
    }

    @PostMapping("/{advertisementId}")
    public ResponseEntity<String> save(@RequestBody MultipartFile file, @PathVariable Long advertisementId) throws IOException {
        return ResponseEntity.ok(advertisementPictureService.save(file, advertisementId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return ResponseEntity.ok(advertisementPictureService.delete(id));
    }

    @PutMapping("/setPrimary/{advertisementId}/{id}")
    public ResponseEntity<AdvertisementPicture> setPrimary(@PathVariable Long advertisementId, @PathVariable int id) {
        return ResponseEntity.ok(advertisementPictureService.setPrimaryById(advertisementId, id));
    }

    @GetMapping("/getPrimaryByAdvertisementId/{advertisementId}")
    public ResponseEntity<AdvertisementPicture> getPrimaryByAdvertisementId(@PathVariable Long advertisementId) {
        return ResponseEntity.ok(advertisementPictureService.getPrimaryByAdvertisementId(advertisementId));
    }
}

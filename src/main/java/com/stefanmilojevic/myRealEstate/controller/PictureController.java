package com.stefanmilojevic.myRealEstate.controller;


import com.stefanmilojevic.myRealEstate.model.City;
import com.stefanmilojevic.myRealEstate.model.Picture;
import com.stefanmilojevic.myRealEstate.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RequestMapping("/pictures")
@RestController
public class PictureController {

    private final PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping()
    public ResponseEntity<String> uploadPicture(@RequestBody MultipartFile file) throws SQLException, IOException {
        return ResponseEntity.ok(pictureService.uploadPhoto(file));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Picture> getById(@PathVariable int id) {
        return ResponseEntity.ok(pictureService.getById(id));
    }

}

package com.stefanmilojevic.myRealEstate.controller;


import com.stefanmilojevic.myRealEstate.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RequestMapping("/picture")
@RestController
public class PictureController {

    private final PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping("/uploadPicture")
    public ResponseEntity<String> uploadPicture(@RequestBody MultipartFile file) throws SQLException, IOException {
        return ResponseEntity.ok(pictureService.uploadPhoto(file));
    }
}

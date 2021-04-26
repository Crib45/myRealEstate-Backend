package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

public interface PictureService {
    String uploadPhoto(MultipartFile file) throws IOException, SQLException;
    Picture getById(int id);
}

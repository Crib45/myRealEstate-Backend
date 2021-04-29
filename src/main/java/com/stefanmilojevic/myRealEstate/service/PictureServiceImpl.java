package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Picture;
import com.stefanmilojevic.myRealEstate.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class PictureServiceImpl implements PictureService{

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String uploadPhoto(MultipartFile file) throws SQLException, IOException {
        Picture picture = new Picture();
        picture.setFileName(file.getOriginalFilename());
        picture.setTitle(file.getOriginalFilename());
        picture.setContentType(file.getContentType());
        picture.setCaption("test picture");
        byte[] imgBytes = file.getBytes();
        picture.setImgBlob(imgBytes);
//        picture.setImgBlob(new javax.sql.rowset.serial.SerialBlob(imgBytes));
        pictureRepository.save(picture);
        return "Success";
    }

    @Override
    public Picture getById(int id) {
        return pictureRepository.findById(id);
    }
}

package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Picture;
import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.repository.PictureRepository;
import com.stefanmilojevic.myRealEstate.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@Service
public class PictureServiceImpl implements PictureService {

    /**
     * Returns a <code>Picture</code> object from <code>MultipartFile</code>
     * @param file <code>MultipartFile</code>
     * @return <code>Picture</code>
     * @throws IOException IO exception for byte reading
     */
    Picture createPicture(MultipartFile file) throws IOException {
        Picture picture = new Picture();
        picture.setFileName(file.getOriginalFilename());
        picture.setTitle(file.getOriginalFilename());
        picture.setContentType(file.getContentType());
        byte[] imgBytes = file.getBytes();
        picture.setImgBlob(imgBytes);
        return picture;
    }

    private final PictureRepository pictureRepository;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String uploadPhoto(MultipartFile file) throws SQLException, IOException {
        Picture picture = createPicture(file);
        pictureRepository.save(picture);
        return "Success";
    }

    @Override
    public Picture getById(int id) {
        return pictureRepository.findById(id);
    }

    @Override
    public String saveForLoggedUser(MultipartFile file, HttpServletRequest request) throws IOException {
        String email = UserUtil.getEmailFromRequest(request);
        User user = userService.getByEmail(email);
        Picture picture = createPicture(file);
        picture.setUser(user);
        Picture savedPicture = pictureRepository.saveAndFlush(picture);
        user.setPicture(picture);
        userService.save(user);
        return "Success";
    }

    @Override
    public Picture getByUserId(Long userId) {
        return pictureRepository.findByUser_Id(userId);
    }
}

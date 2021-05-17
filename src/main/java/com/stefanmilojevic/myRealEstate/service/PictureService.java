package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Picture;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public interface PictureService {
    /**
     * Upload a photo to server
     * @param file <code>MultipartFile</code> from request
     * @return Success string message
     * @throws IOException  IO exception
     * @throws SQLException SQL exception
     */
    String uploadPhoto(MultipartFile file) throws IOException, SQLException;

    /**
     * Return picture by its id
     * @param id Id of picture
     * @return <code>Picture</code>
     */
    Picture getById(int id);

    /**
     * Save profile picture of logged user
     * @param file Picture for saving
     * @param request Http request with user data
     * @return Success message
     */
    String saveForLoggedUser(MultipartFile file, HttpServletRequest request) throws IOException;

    /**
     * Returns Picture by id of picture owner
     * @param userId id of <code>User</code> owning picture
     * @return <code>Picture</code>
     */
    Picture getByUserId(Long userId);
}

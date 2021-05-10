package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.AdvertisementPicture;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AdvertisementPictureService {
    /**
     * Returns list of all pictures for selected advertisement by advertisement id
     * @param advertisementId id of advertisement
     * @return List of AdvertisementPicture type
     */
    List<AdvertisementPicture> getAllByAdvertisementId(int advertisementId);

    /**
     * Saves AdvertisementPicture
     * @param file MultipartFile
     * @return Success message
     */
    String save(MultipartFile file, int advertisementId) throws IOException;

    String delete(int id);
}

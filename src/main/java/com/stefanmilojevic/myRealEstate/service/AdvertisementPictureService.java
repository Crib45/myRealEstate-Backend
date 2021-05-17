package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
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

    /**
     * Delete Advertisement picture by id
     * @param id Id of picture
     * @return Success message
     */
    String delete(int id);

    /**
     * Sets advertisement picture as primary and rest to false;
     * @param advertisementId Id of Advertisement
     * @param id Id of Advertisement picture to be set to primary
     * @return AdvertisementPicture primary object
     */
    AdvertisementPicture setPrimaryById(int advertisementId, int id);

    /**
     * Get Primary picture of advertisement
     * @param advertisementId id of advertisement
     * @return <code>AdvertisementPicture</code>
     */
    AdvertisementPicture getPrimaryByAdvertisementId(int advertisementId);
}

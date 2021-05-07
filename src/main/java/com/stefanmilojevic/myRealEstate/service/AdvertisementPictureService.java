package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.AdvertisementPicture;

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
     * @param advertisementPicture AdvertisementPicture
     * @return Success message
     */
    String save(AdvertisementPicture advertisementPicture);
}

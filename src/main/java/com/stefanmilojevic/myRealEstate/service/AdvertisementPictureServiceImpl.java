package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.AdvertisementPicture;
import com.stefanmilojevic.myRealEstate.repository.AdvertisementPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementPictureServiceImpl implements AdvertisementPictureService {

    private final AdvertisementPictureRepository advertisementPictureRepository;

    @Autowired
    public AdvertisementPictureServiceImpl( AdvertisementPictureRepository advertisementPictureRepository ) {
        this.advertisementPictureRepository = advertisementPictureRepository;
    }

    @Override
    public List<AdvertisementPicture> getAllByAdvertisementId(int advertisementId) {
        return advertisementPictureRepository.findAllByAdvertisement_Id(advertisementId);
    }

    @Override
    public String save(AdvertisementPicture advertisementPicture) {
        advertisementPictureRepository.save(advertisementPicture);
        return "Success";
    }
}

package com.stefanmilojevic.myRealEstate.repository;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.AdvertisementPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementPictureRepository extends JpaRepository<AdvertisementPicture, Long> {
    List<AdvertisementPicture> findAllByAdvertisement_Id(int advertisementId);
}
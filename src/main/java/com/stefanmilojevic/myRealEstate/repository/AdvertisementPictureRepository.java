package com.stefanmilojevic.myRealEstate.repository;

import com.stefanmilojevic.myRealEstate.model.AdvertisementPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementPictureRepository extends JpaRepository<AdvertisementPicture, Integer> {
    List<AdvertisementPicture> findAllByAdvertisement_Id(Long advertisementId);
    AdvertisementPicture findById(int id);
    AdvertisementPicture findByPrimaryPicIsTrueAndAdvertisement_Id(Long advertisementId);
}

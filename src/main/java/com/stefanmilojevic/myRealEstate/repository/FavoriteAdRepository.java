package com.stefanmilojevic.myRealEstate.repository;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.FavoriteAd;
import com.stefanmilojevic.myRealEstate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteAdRepository extends JpaRepository<FavoriteAd, Long> {
    FavoriteAd findByAdvertisementAndUser(Advertisement advertisement, User user);
    List<FavoriteAd> findAllByUser(User user);
    FavoriteAd findByUserAndAdvertisement_Id(User user, Long advertId);
}

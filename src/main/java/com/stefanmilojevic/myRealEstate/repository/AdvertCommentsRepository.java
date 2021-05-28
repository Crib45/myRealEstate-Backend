package com.stefanmilojevic.myRealEstate.repository;

import com.stefanmilojevic.myRealEstate.model.AdvertComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertCommentsRepository extends JpaRepository<AdvertComments, Long> {
    List<AdvertComments> findAllByAdvertisement_Id(Long advertId);
}

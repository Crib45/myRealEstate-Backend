package com.stefanmilojevic.myRealEstate.repository;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.Category;
import com.stefanmilojevic.myRealEstate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findAllByOwner(User user);
    List<Advertisement> findAllByPublishedAndEstate_SubCategoryId(Boolean published,int subcategoryId);
    List<Advertisement> findAllByPublishedAndCreatedAtAfterAndEstate_SubCategory_Category(Boolean published, Timestamp createdAt, Category _category);
    List<Advertisement> findAllByPublishedAndEstate_SubCategory_Category(Boolean published, Category category);
}

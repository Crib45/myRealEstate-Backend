package com.stefanmilojevic.myRealEstate.repository;

import com.stefanmilojevic.myRealEstate.model.ProfileComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileCommentsRepository extends JpaRepository<ProfileComments, Long> {
    List<ProfileComments> findAllByMadeFor_Id(Long userId);
}

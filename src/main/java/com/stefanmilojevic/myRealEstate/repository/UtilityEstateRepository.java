package com.stefanmilojevic.myRealEstate.repository;

import com.stefanmilojevic.myRealEstate.model.Utility;
import com.stefanmilojevic.myRealEstate.model.UtilityEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityEstateRepository extends JpaRepository<UtilityEstate, Long> {
    UtilityEstate findByEstate_IdAndUtility(Long id, Utility utility);
}

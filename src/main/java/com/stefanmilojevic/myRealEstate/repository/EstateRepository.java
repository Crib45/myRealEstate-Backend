package com.stefanmilojevic.myRealEstate.repository;

import com.stefanmilojevic.myRealEstate.model.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateRepository extends JpaRepository<Estate, Long> {
    Estate findById(int id);
}

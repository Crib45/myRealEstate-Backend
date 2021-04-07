package com.stefanmilojevic.myRealEstate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileCommentsRepository extends JpaRepository<ProfileCommentsRepository, Long> {
}

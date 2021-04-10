package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.repository.FavoriteAdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteAdServiceImpl implements FavoriteAdService {

    private final FavoriteAdRepository favoriteAdRepository;

    @Autowired
    public FavoriteAdServiceImpl(FavoriteAdRepository favoriteAdRepository) {
        this.favoriteAdRepository = favoriteAdRepository;
    }
}

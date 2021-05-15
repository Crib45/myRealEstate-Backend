package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.FavoriteAd;
import com.stefanmilojevic.myRealEstate.model.User;

import javax.servlet.http.HttpServletRequest;

public interface FavoriteAdService {
    /**
     * Gets FavoriteAdd by given advertisement and user
     * @param advertisement Advertisement object
     * @param user User object
     * @return FavoriteAd for given advertisement and user
     */
    FavoriteAd getByAdvertisementAndUser(Advertisement advertisement, User user);

    /**
     * Save new FavoriteAd
     * @param advertisement Advertisement for saving
     * @param request Http request to get user
     * @return Object created by saving
     */
    FavoriteAd save(Advertisement advertisement, HttpServletRequest request);

    String delete(Long id);
}

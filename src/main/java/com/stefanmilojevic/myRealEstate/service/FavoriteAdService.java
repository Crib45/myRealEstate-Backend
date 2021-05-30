package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.FavoriteAd;
import com.stefanmilojevic.myRealEstate.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    /**
     * Delete given <code>FavoriteAd</code> entry
     * @param id id of <code>FavoriteAd</code>
     * @return Success message string
     */
    String delete(Long id);

    /**
     * Returns list of <code>FavoriteAd</code> by logged user
     * @param request <code>HttpServletRequest</code>
     * @return List of <code>FavoriteAd</code>
     */
    List<FavoriteAd> getAllForLogged(HttpServletRequest request);

    /**
     * Returns <code>FavoriteAd</code> by logged <code>User</code> and id of <code>Advertisement</code>
     * @param advertId id of <code>Advertisement</code>
     * @param request <code>HttpServletRequest</code>
     * @return <code>FavoriteAd</code>
     */
    FavoriteAd getByAdvertIdForLogged(Long advertId, HttpServletRequest request);
}

package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Advertisement;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdvertisementService {
    /**
     * Saves Advertisement object
     * @param advertisement object for saving
     * @return Saved Advertisement with generated id
     */
    Advertisement save(Advertisement advertisement, HttpServletRequest request);

    /**
     * Finds logged user by email from HttpServletRequest and returns all its advertisements
     * @param request HttpServletRequest from REST call
     * @return List of advertisements
     */
    List<Advertisement> getAllByLogged(HttpServletRequest request);

    /**
     * Deletes selected advertisement from db
     * @param id id of Advertisement for deleting
     */
    String delete(int id);

    /**
     * Returns Advertisement by id
     * @param id id of Advertisement
     * @return Advertisement
     */
    Advertisement getById(int id);
}

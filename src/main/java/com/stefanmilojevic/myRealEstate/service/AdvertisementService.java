package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.dto.AdvertisementDTO;
import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.SavedFilter;
import com.stefanmilojevic.myRealEstate.model.User;

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
     * Update edit date and save for advertisement by id
     * @param id id of <code>Advertisement</code>
     * @return saved advertisement
     */
    Advertisement updateEditDate(Long id);

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
    String delete(Long id);

    /**
     * Returns Advertisement by id
     * @param id id of Advertisement
     * @return Advertisement
     */
    Advertisement getById(Long id);

    /**
     * Changes publish status of given advertisement to true
     * @param id Id of Advertisement
     * @return Advertisement
     */
    Advertisement publish(Long id);

    /**
     * Get all published <code>Advertisements</code> of selected <code>SubCategory</code>
     * @param subcategoryId id of <code>SubCategory</code>
     * @return List of <code>Advertisement</code>
     */
    List<Advertisement> getAllPublishedBySubCategoryId(int subcategoryId);

    /**
     * Get all published <code>AdvertisementDTO</code> of selected <code>SubCategory</code>
     * @param subcategoryId id of <code>SubCategory</code>
     * @return List of <code>Advertisement</code>
     */
    List<AdvertisementDTO> getAllPublishedDTOBySubCategoryId(int subcategoryId, HttpServletRequest request);

    /**
     * Updates commentsCheckedAt date
     * @param advertisement for updating <code>Advertisement</code>
     * @return Success string
     */
    String updateCommentsCheckedAt(Advertisement advertisement);

    /**
     * Returns all <code>Advertisement</code> made after last checked date on <code>SavedFilter</code>
     * that are within filter range
     * @param savedFilter <code>SavedFilter</code>
     * @param user <code>User</code>
     * @return List of <code>Advertisement</code>
     */
    List<Advertisement> getByFilter(SavedFilter savedFilter, User user);
}

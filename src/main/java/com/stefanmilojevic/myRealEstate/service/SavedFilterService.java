package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.SavedFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SavedFilterService {
    /**
     * Return all <code>SavedFilter</code> for logged <code>User</code>
     * @param request <code>HttpServletRequest</code>
     * @return List of <code>SavedFilter</code>
     */
    List<SavedFilter> getAllForLogged(HttpServletRequest request);

    /**
     * Delete <code>SavedFilter</code> by id
     * @param id Id of <code>SavedFilter</code>
     * @return Success string
     */
    String delete(Long id);

    /**
     * Save <code>SavedFilter</code> for logged user
     * @param savedFilter <code>SavedFilter</code> for saving
     * @param request <code>HttpServletRequest</code> request containing user
     * @return Success string
     */
    String save(SavedFilter savedFilter, HttpServletRequest request);
}

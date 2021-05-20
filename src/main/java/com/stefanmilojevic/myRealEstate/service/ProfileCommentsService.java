package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.ProfileComments;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProfileCommentsService {
    /**
     * Return all <code>ProfileComments</code> for given <code>User</code>
     * @param userId id of <code>User</code>
     * @return List of <code>ProfileComments</code>
     */
    List<ProfileComments> getAllByUserId(Long userId);

    /**
     * Save comment and return new list
     * @param profileComments <code>ProfileComments</code>
     * @return List of <code>ProfileComments</code> after saving
     */
    List<ProfileComments> save(ProfileComments profileComments, HttpServletRequest request);
}

package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.AdvertComments;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdvertCommentsService {
    /**
     * Saves given <code>AdvertComment</code>
     * @param advertComments <code>AdvertComment</code>
     * @return Success message string
     */
    String save(AdvertComments advertComments, HttpServletRequest request);

    /**
     * Returns all <code>AdvertComments</code> by id of <code>Advertisement</code>
     * @param advertId id of <code>Advertisement</code>
     * @return List of <code>AdvertComments</code>
     */
    List<AdvertComments> getAllByAdvertId(Long advertId);
}

package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.AdvertComments;

import java.util.List;

public interface AdvertCommentsService {
    /**
     * Saves given <code>AdvertComment</code>
     * @param advertComments <code>AdvertComment</code>
     * @return Success message string
     */
    String save(AdvertComments advertComments);

    List<AdvertComments> getAllByAdvertId(Long advertId);
}

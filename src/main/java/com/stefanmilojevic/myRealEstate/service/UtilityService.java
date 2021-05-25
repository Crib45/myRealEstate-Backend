package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Utility;

import java.util.List;

public interface UtilityService {
    /**
     * Returns list of all Utilities available for sub category of advertisement
     * @param id id of advertisement
     * @return List of <code>Utility</code>
     */
    List<Utility> getAllByAdvertId(Long id);
}

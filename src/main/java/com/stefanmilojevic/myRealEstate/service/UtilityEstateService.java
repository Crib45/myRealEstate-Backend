package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.UtilityEstate;

import java.util.List;

public interface UtilityEstateService {
    /**
     * Returns list of all UtilityEstate available for sub category of advertisement
     * @param advertId id of advertisement
     * @return List of <code>UtilityEstate</code>
     */
    List<UtilityEstate> getAllByAdvertId(Long advertId);

    /**
     * Updates/Creates given list of <code>UtilityEstate</code>
     * @param utilityEstateList List <code>UtilityEstate</code> for saving
     * @return Success message
     */
    String saveAll(List<UtilityEstate> utilityEstateList);
}

package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Estate;
import com.stefanmilojevic.myRealEstate.model.Utility;
import com.stefanmilojevic.myRealEstate.model.UtilityEstate;
import com.stefanmilojevic.myRealEstate.repository.UtilityEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilityEstateServiceImpl implements UtilityEstateService {

    private final UtilityEstateRepository utilityEstateRepository;

    private final UtilityService utilityService;
    private final EstateService estateService;

    @Autowired
    public UtilityEstateServiceImpl(UtilityEstateRepository utilityEstateRepository,
                                    UtilityService utilityService,
                                    EstateService estateService) {
        this.utilityEstateRepository = utilityEstateRepository;
        this.utilityService = utilityService;
        this.estateService = estateService;
    }

    @Override
    public List<UtilityEstate> getAllByAdvertId(Long advertId) {
        Estate estate = estateService.findById(advertId);
        List<Utility> utilityList = utilityService.getAllByAdvertId(advertId);
        List<UtilityEstate> utilityEstateList = new ArrayList<>();
        for (Utility utility: utilityList) {
            UtilityEstate utilityEstate = utilityEstateRepository.findByEstate_IdAndUtility(advertId, utility);
            if (utilityEstate == null) {
                utilityEstate = new UtilityEstate();
                utilityEstate.setUtility(utility);
                utilityEstate.setEstate(estate);
                utilityEstate.setValue(false);
            }
            utilityEstateList.add(utilityEstate);
        }
        return utilityEstateList;
    }

    @Override
    public String saveAll(List<UtilityEstate> utilityEstateList) {
        utilityEstateRepository.saveAll(utilityEstateList);
        return "Success";
    }
}

package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.AdvertComments;
import com.stefanmilojevic.myRealEstate.repository.AdvertCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertCommentsServiceImpl implements AdvertCommentsService {

    private final AdvertCommentsRepository advertCommentsRepository;

    @Autowired
    public AdvertCommentsServiceImpl(AdvertCommentsRepository advertCommentsRepository) {
        this.advertCommentsRepository = advertCommentsRepository;
    }

    @Override
    public String save(AdvertComments advertComments) {
        advertCommentsRepository.save(advertComments);
        return "Success";
    }

    @Override
    public List<AdvertComments> getAllByAdvertId(Long advertId) {
        return advertCommentsRepository.findAllByAdvertisement_Id(advertId);
    }
}

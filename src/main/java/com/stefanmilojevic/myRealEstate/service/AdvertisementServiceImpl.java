package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.Estate;
import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.repository.AdvertisementRepository;
import com.stefanmilojevic.myRealEstate.repository.EstateRepository;
import com.stefanmilojevic.myRealEstate.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final EstateRepository estateRepository;
    private UserService userService;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository,
                                    EstateRepository estateRepository) {
        this.advertisementRepository = advertisementRepository;
        this.estateRepository = estateRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Advertisement save(Advertisement advertisement, HttpServletRequest request) {
        User user = userService.getByEmail(UserUtil.getEmailFromRequest(request));
        advertisement.setOwner(user);
        if(advertisement.getId() != 0) {
            Advertisement advertisementForSave = advertisementRepository.findById(advertisement.getId());
            advertisement.setEditedAt(new Timestamp(System.currentTimeMillis()));
            advertisementForSave.setEditedAt(advertisement.getEditedAt());
            advertisementForSave.setTitle(advertisement.getTitle());
            Estate estate = estateRepository.findById(advertisementForSave.getId());
            estate.setCity(advertisement.getEstate().getCity());
            estate.setSize(advertisement.getEstate().getSize());
            estate.setSubCategory(advertisement.getEstate().getSubCategory());
            advertisementForSave.setEstate(estate);
            advertisementForSave.setExpireDate(advertisement.getExpireDate());
            advertisementForSave.setPublished(advertisement.getPublished());
            advertisementRepository.save(advertisementForSave);
        }
        else {
            advertisement.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            advertisementRepository.save(advertisement);
        }

        return advertisement;
    }

    @Override
    public List<Advertisement> getAllByLogged(HttpServletRequest request) {
        User user = userService.getByEmail(UserUtil.getEmailFromRequest(request));
        return advertisementRepository.findAllByOwner(user);
    }

    @Override
    public String delete(int id) {
        Advertisement advertisement = advertisementRepository.findById(id);
        advertisementRepository.delete(advertisement);
        return "Success";
    }

    @Override
    public Advertisement getById(int id) {
        return advertisementRepository.findById(id);
    }

    @Override
    public Advertisement publish(int id) {
        Advertisement advertisement = advertisementRepository.findById(id);
        advertisement.setPublished(true);
        return advertisementRepository.save(advertisement);
    }


}

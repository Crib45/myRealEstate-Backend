package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.repository.AdvertisementRepository;
import com.stefanmilojevic.myRealEstate.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private UserService userService;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Advertisement save(Advertisement advertisement, HttpServletRequest request) {
        advertisement.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        User user = userService.getByEmail(UserUtil.getEmailFromRequest(request));
        advertisement.setOwner(user);
        advertisementRepository.save(advertisement);
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

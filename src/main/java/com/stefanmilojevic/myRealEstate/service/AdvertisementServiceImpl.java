package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.dto.AdvertisementDTO;
import com.stefanmilojevic.myRealEstate.model.*;
import com.stefanmilojevic.myRealEstate.repository.AdvertisementRepository;
import com.stefanmilojevic.myRealEstate.repository.EstateRepository;
import com.stefanmilojevic.myRealEstate.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final EstateRepository estateRepository;
    private AdvertisementPictureService advertisementPictureService;
    private UserService userService;
    private FavoriteAdService favoriteAdService;

    @Autowired
    private void setAdvertisementPictureService(AdvertisementPictureService advertisementPictureService) {
        this.advertisementPictureService = advertisementPictureService;
    }

    @Autowired
    private void setFavoriteAdService(FavoriteAdService favoriteAdService) {
        this.favoriteAdService = favoriteAdService;
    }

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
            Advertisement advertisementForSave = advertisementRepository.findById(advertisement.getId()).orElse(null);
            advertisement.setEditedAt(new Timestamp(System.currentTimeMillis()));
            assert advertisementForSave != null;
            advertisementForSave.setEditedAt(advertisement.getEditedAt());
            advertisementForSave.setTitle(advertisement.getTitle());
            Estate estate = estateRepository.findById(advertisementForSave.getId()).orElse(null);
            assert estate != null;
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
    public String delete(Long id) {
        Advertisement advertisement = advertisementRepository.findById(id).orElse(null);
        assert advertisement != null;
        advertisementRepository.delete(advertisement);
        return "Success";
    }

    @Override
    public Advertisement getById(Long id) {
        return advertisementRepository.findById(id).orElse(null);
    }

    @Override
    public Advertisement publish(Long id) {
        Advertisement advertisement = advertisementRepository.findById(id).orElse(null);
        assert advertisement != null;
        advertisement.setPublished(true);
        return advertisementRepository.save(advertisement);
    }

    @Override
    public List<Advertisement> getAllPublishedBySubCategoryId(int subcategoryId) {
        return advertisementRepository.findAllByPublishedAndEstate_SubCategoryId(true,subcategoryId);
    }

    @Override
    public List<AdvertisementDTO> getAllPublishedDTOBySubCategoryId(int subcategoryId, HttpServletRequest request) {
        List<Advertisement> advertisementList;
        advertisementList = advertisementRepository.findAllByPublishedAndEstate_SubCategoryId(true,subcategoryId);
        List<AdvertisementDTO> advertisementDTOS = new ArrayList<>();
        for (Advertisement advertisement: advertisementList) {
            AdvertisementDTO advertisementDTO = new AdvertisementDTO();
            advertisementDTO.setAdvertisement(advertisement);
            if(request.getUserPrincipal() != null) {
                String email = UserUtil.getEmailFromRequest(request);
                User user = userService.getByEmail(email);
                FavoriteAd favoriteAd = favoriteAdService.getByAdvertisementAndUser(advertisement, user);
                advertisementDTO.setFavoriteAd(favoriteAd);
            }
            AdvertisementPicture advertisementPicture
                    = advertisementPictureService.getPrimaryByAdvertisementId(advertisement.getId());
            advertisementDTO.setAdvertisementPicture(advertisementPicture);
            advertisementDTOS.add(advertisementDTO);
        }
        return advertisementDTOS;
    }


}

package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.FavoriteAd;
import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.repository.FavoriteAdRepository;
import com.stefanmilojevic.myRealEstate.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class FavoriteAdServiceImpl implements FavoriteAdService {

    private final FavoriteAdRepository favoriteAdRepository;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public FavoriteAdServiceImpl(FavoriteAdRepository favoriteAdRepository) {
        this.favoriteAdRepository = favoriteAdRepository;
    }

    @Override
    public FavoriteAd getByAdvertisementAndUser(Advertisement advertisement, User user) {
        return favoriteAdRepository.findByAdvertisementAndUser(advertisement, user);
    }

    @Override
    public FavoriteAd save(Advertisement advertisement, HttpServletRequest request) {
        FavoriteAd favoriteAd = new FavoriteAd();
        favoriteAd.setAdvertisement(advertisement);
        String email = UserUtil.getEmailFromRequest(request);
        User user = userService.getByEmail(email);
        favoriteAd.setLastChecked(new Timestamp(System.currentTimeMillis()));
        favoriteAd.setUser(user);
        return favoriteAdRepository.saveAndFlush(favoriteAd);
    }

    @Override
    public String delete(Long id) {
        favoriteAdRepository.deleteById(id);
        return "Success";
    }
}

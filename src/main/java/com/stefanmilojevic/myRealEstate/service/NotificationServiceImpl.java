package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.dto.NotificationDTO;
import com.stefanmilojevic.myRealEstate.dto.NotificationType;
import com.stefanmilojevic.myRealEstate.model.*;
import com.stefanmilojevic.myRealEstate.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private UserService userService;
    private AdvertisementService advertisementService;
    private FavoriteAdService favoriteAdService;
    private SavedFilterService savedFilterService;
    private AdvertCommentsService advertCommentsService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setFavoriteAdService(FavoriteAdService favoriteAdService) {
        this.favoriteAdService = favoriteAdService;
    }

    @Autowired
    public void setSavedFilterService(SavedFilterService savedFilterService) {
        this.savedFilterService = savedFilterService;
    }

    @Autowired
    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @Autowired
    public void setAdvertCommentsService(AdvertCommentsService advertCommentsService) {
        this.advertCommentsService = advertCommentsService;
    }

    /**
     * Get all notifications for logged <code>User</code>
     * @param request <code>HttpServletRequest</code>
     * @return List of <code>NotificationDTO</code>
     */
    private List<NotificationDTO> getNotifications(HttpServletRequest request) {
        List<NotificationDTO> notificationDTOList = new ArrayList<>();
        List<FavoriteAd> favoriteAds = favoriteAdService.getAllForLogged(request);
        for (FavoriteAd favoriteAd: favoriteAds) {
            if(favoriteAd.getAdvertisement().getEditedAt().after(favoriteAd.getLastChecked())) {
                NotificationDTO notificationDTO = new NotificationDTO();
                notificationDTO.setMessage("Oglas koji pratite je ažuriran");
                notificationDTO.setNotificationType(NotificationType.FavoriteAd);
                notificationDTO.setFavoriteAd(favoriteAd);
                notificationDTOList.add(notificationDTO);
            }
        }
        //For owned adverts check if new comment is present
        List<Advertisement> advertisementList = advertisementService.getAllByLogged(request);
        for (Advertisement advertisement: advertisementList) {
            List<AdvertComments> advertComments = advertCommentsService.getAllByAdvertId(advertisement.getId());
            for (AdvertComments advertComment: advertComments) {
                if(advertisement.getCommentsCheckedAt() == null
                        || advertisement.getCommentsCheckedAt().before(advertComment.getCreatedAt())) {
                    NotificationDTO notificationDTO = new NotificationDTO();
                    notificationDTO.setMessage("Novi komentar na oglasu");
                    notificationDTO.setNotificationType(NotificationType.Advert);
                    notificationDTO.setAdvertisement(advertisement);
                    notificationDTOList.add(notificationDTO);
                    break;
                }
            }
        }

        //TODO notification for comments on user profile
        return notificationDTOList;
    }


    @Override
    public List<NotificationDTO> getAllNotifications(HttpServletRequest request) {

        return null;
    }

    @Override
    public Integer getNumOfNotifications(HttpServletRequest request) {

        return null;
    }
}

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
    private ProfileCommentsService profileCommentsService;

    @Autowired
    public void setProfileCommentsService(ProfileCommentsService profileCommentsService) {
        this.profileCommentsService = profileCommentsService;
    }

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
        String email = UserUtil.getEmailFromRequest(request);
        User user = userService.getByEmail(email);
        List<NotificationDTO> notificationDTOList = new ArrayList<>();
        //If favoriteAd is changed
        List<FavoriteAd> favoriteAds = favoriteAdService.getAllForLogged(request);
        for (FavoriteAd favoriteAd: favoriteAds) {
            if(favoriteAd.getAdvertisement().getEditedAt() != null &&
                    favoriteAd.getAdvertisement().getEditedAt().after(favoriteAd.getLastChecked())) {
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
                    notificationDTO.setNotificationType(NotificationType.OwnedAdvert);
                    notificationDTO.setAdvertisement(advertisement);
                    notificationDTOList.add(notificationDTO);
                    break;
                }
            }
        }
        //For not seen profile comments
        List<ProfileComments> profileCommentsList = profileCommentsService.getAllByUserId(user.getId());
        for (ProfileComments profileComments: profileCommentsList) {
            if(profileComments.getSeen() == null || !profileComments.getSeen()) {
                NotificationDTO notificationDTO = new NotificationDTO();
                notificationDTO.setMessage("Novi komentari na vašem profilu");
                notificationDTO.setNotificationType(NotificationType.ProfileComments);
                notificationDTOList.add(notificationDTO);
                break;
            }
        }
        //SavedFilter counter
        List<SavedFilter> savedFilterList = savedFilterService.getAllForLogged(request);
        for (SavedFilter savedFilter: savedFilterList) {
            List<Advertisement> filteredAdverts = advertisementService.getByFilter(savedFilter, user);
            if(!filteredAdverts.isEmpty()) {
                NotificationDTO notificationDTO = new NotificationDTO();
                notificationDTO.setMessage("Pronađeni oglasi koji odgovaraju filteru");
                notificationDTO.setNotificationType(NotificationType.SavedFilter);
                notificationDTO.setSavedFilter(savedFilter);
                notificationDTOList.add(notificationDTO);
            }
        }
        return notificationDTOList;
    }


    @Override
    public List<NotificationDTO> getAll(HttpServletRequest request) {
        return getNotifications(request);
    }

    @Override
    public Integer getNum(HttpServletRequest request) {
        return getNotifications(request).size();
    }
}

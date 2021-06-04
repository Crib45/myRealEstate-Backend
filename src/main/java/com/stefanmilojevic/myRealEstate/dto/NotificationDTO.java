package com.stefanmilojevic.myRealEstate.dto;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.FavoriteAd;
import com.stefanmilojevic.myRealEstate.model.SavedFilter;


public class NotificationDTO {
    String message;
    NotificationType notificationType;
    FavoriteAd favoriteAd;
    SavedFilter savedFilter;
    Advertisement advertisement;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }



    public SavedFilter getSavedFilter() {
        return savedFilter;
    }

    public void setSavedFilter(SavedFilter savedFilter) {
        this.savedFilter = savedFilter;
    }

    public FavoriteAd getFavoriteAd() {
        return favoriteAd;
    }

    public void setFavoriteAd(FavoriteAd favoriteAd) {
        this.favoriteAd = favoriteAd;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}

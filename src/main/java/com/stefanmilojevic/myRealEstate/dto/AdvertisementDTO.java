package com.stefanmilojevic.myRealEstate.dto;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.AdvertisementPicture;
import com.stefanmilojevic.myRealEstate.model.FavoriteAd;

import java.util.Objects;

public class AdvertisementDTO {
    private Advertisement advertisement;
    private AdvertisementPicture advertisementPicture;
    private FavoriteAd favoriteAd;

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public AdvertisementPicture getAdvertisementPicture() {
        return advertisementPicture;
    }

    public void setAdvertisementPicture(AdvertisementPicture advertisementPicture) {
        this.advertisementPicture = advertisementPicture;
    }

    public FavoriteAd getFavoriteAd() {
        return favoriteAd;
    }

    public void setFavoriteAd(FavoriteAd favoriteAd) {
        this.favoriteAd = favoriteAd;
    }

    @Override
    public String toString() {
        return "AdvertisementDTO{" +
                "advertisement=" + advertisement +
                ", advertisementPicture=" + advertisementPicture +
                ", isFavorite=" + favoriteAd +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvertisementDTO that = (AdvertisementDTO) o;
        return Objects.equals(advertisement, that.advertisement) && Objects.equals(advertisementPicture, that.advertisementPicture) && Objects.equals(favoriteAd, that.favoriteAd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(advertisement, advertisementPicture, favoriteAd);
    }
}

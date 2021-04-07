package com.stefanmilojevic.myRealEstate.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "favorite_ad", schema = "myrealestate", catalog = "")
public class FavoriteAd {
    private int id;
    private Integer userId;
    private Integer advertisementId;
    private Timestamp lastChecked;
    private User userByUserId;
    private Advertisement advertisementByAdvertisementId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "last_checked")
    public Timestamp getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(Timestamp lastChecked) {
        this.lastChecked = lastChecked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoriteAd that = (FavoriteAd) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (advertisementId != null ? !advertisementId.equals(that.advertisementId) : that.advertisementId != null)
            return false;
        if (lastChecked != null ? !lastChecked.equals(that.lastChecked) : that.lastChecked != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (advertisementId != null ? advertisementId.hashCode() : 0);
        result = 31 * result + (lastChecked != null ? lastChecked.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "advertisement_id", referencedColumnName = "id")
    public Advertisement getAdvertisementByAdvertisementId() {
        return advertisementByAdvertisementId;
    }

    public void setAdvertisementByAdvertisementId(Advertisement advertisementByAdvertisementId) {
        this.advertisementByAdvertisementId = advertisementByAdvertisementId;
    }
}

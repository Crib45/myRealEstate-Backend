package com.stefanmilojevic.myRealEstate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Advertisement {
    private int id;
    private String title;
    private String description;
    private Integer price;
    private Byte finished;
    private Timestamp expireDate;
    private Timestamp createdAt;
    private Timestamp editedAt;
    private Integer ownerId;
    private List<AdvertComments> advertCommentsById;
    private User userByOwnerId;
    private List<Estate> estatesById;
    private List<FavoriteAd> favoriteAdsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "finished")
    public Byte getFinished() {
        return finished;
    }

    public void setFinished(Byte finished) {
        this.finished = finished;
    }

    @Basic
    @Column(name = "expire_date")
    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "edited_at")
    public Timestamp getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(Timestamp editedAt) {
        this.editedAt = editedAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advertisement that = (Advertisement) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (finished != null ? !finished.equals(that.finished) : that.finished != null) return false;
        if (expireDate != null ? !expireDate.equals(that.expireDate) : that.expireDate != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (editedAt != null ? !editedAt.equals(that.editedAt) : that.editedAt != null) return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (finished != null ? finished.hashCode() : 0);
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (editedAt != null ? editedAt.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "advertisementByAdvertisementId")
    public List<AdvertComments> getAdvertCommentsById() {
        return advertCommentsById;
    }

    public void setAdvertCommentsById(List<AdvertComments> advertCommentsById) {
        this.advertCommentsById = advertCommentsById;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    public User getUserByOwnerId() {
        return userByOwnerId;
    }

    public void setUserByOwnerId(User userByOwnerId) {
        this.userByOwnerId = userByOwnerId;
    }

    @OneToMany(mappedBy = "advertisementByAdvertisementId")
    public List<Estate> getEstatesById() {
        return estatesById;
    }

    public void setEstatesById(List<Estate> estatesById) {
        this.estatesById = estatesById;
    }

    @OneToMany(mappedBy = "advertisementByAdvertisementId")
    public List<FavoriteAd> getFavoriteAdsById() {
        return favoriteAdsById;
    }

    public void setFavoriteAdsById(List<FavoriteAd> favoriteAdsById) {
        this.favoriteAdsById = favoriteAdsById;
    }
}
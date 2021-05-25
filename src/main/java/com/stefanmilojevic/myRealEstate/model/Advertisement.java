package com.stefanmilojevic.myRealEstate.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Advertisement {
    private Long id;
    private String title;
    private String description;
    private Integer price;
    private Boolean finished;
    private Timestamp expireDate;
    private Timestamp createdAt;
    private Timestamp editedAt;
    @JsonIgnore
    private List<AdvertComments> advertCommentsById;
    private User owner;
    private Estate estate;
    @JsonIgnore
    private List<FavoriteAd> favoriteAds;
    private Boolean published;
    @JsonIgnore
    private List<AdvertisementPicture> advertisementPictures;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    @Column(name = "finished", nullable = true, columnDefinition = "TINYINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    @Basic
    @Column(name = "published", nullable = true, columnDefinition = "TINYINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
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






    @OneToMany(mappedBy = "advertisementByAdvertisementId")
    public List<AdvertComments> getAdvertCommentsById() {
        return advertCommentsById;
    }

    public void setAdvertCommentsById(List<AdvertComments> advertCommentsById) {
        this.advertCommentsById = advertCommentsById;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @OneToOne(mappedBy = "advertisement", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
//    @Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
//    @PrimaryKeyJoinColumn
    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
//        this.estate = estate;
        if (estate == null) {
            if (this.estate != null) {
                this.estate.setAdvertisement(null);
            }
        }
        else {
            estate.setAdvertisement(this);
        }
        this.estate = estate;
    }

    @OneToMany(mappedBy = "advertisement")
    public List<FavoriteAd> getFavoriteAds() {
        return favoriteAds;
    }

    public void setFavoriteAds(List<FavoriteAd> favoriteAds) {
        this.favoriteAds = favoriteAds;
    }

    @OneToMany(mappedBy = "advertisement")
    public List<AdvertisementPicture> getAdvertisementPictures() {
        return advertisementPictures;
    }

    public void setAdvertisementPictures(List<AdvertisementPicture> advertisementPictures) {
        this.advertisementPictures = advertisementPictures;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", finished=" + finished +
                ", expireDate=" + expireDate +
                ", createdAt=" + createdAt +
                ", editedAt=" + editedAt +
                ", advertCommentsById=" + advertCommentsById +
                ", owner=" + owner +
                ", estate=" + estate +
                ", favoriteAdsById=" + favoriteAds +
                ", published=" + published +
                ", advertisementPictures=" + advertisementPictures +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return id.equals(that.id) && title.equals(that.title) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(finished, that.finished) && Objects.equals(expireDate, that.expireDate) && Objects.equals(createdAt, that.createdAt) && Objects.equals(editedAt, that.editedAt) && Objects.equals(advertCommentsById, that.advertCommentsById) && Objects.equals(owner, that.owner) && Objects.equals(estate, that.estate) && Objects.equals(favoriteAds, that.favoriteAds) && Objects.equals(published, that.published) && Objects.equals(advertisementPictures, that.advertisementPictures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, finished, expireDate, createdAt, editedAt, advertCommentsById, owner, estate, favoriteAds, published, advertisementPictures);
    }
}

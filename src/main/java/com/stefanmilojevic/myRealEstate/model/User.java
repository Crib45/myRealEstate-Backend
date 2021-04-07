package com.stefanmilojevic.myRealEstate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    private String username;
    private String password;
    private Integer cityId;
    private Timestamp createdAt;
    private List<AdvertComments> advertCommentsById;
    private List<Advertisement> advertisementsById;
    private List<FavoriteAd> favoriteAdsById;
    private List<Message> messagesById;
    private List<Message> messagesById_0;
    private List<ProfileComments> profileCommentsById;
    private List<ProfileComments> profileCommentsById_0;
    private City cityByCityId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (cityId != null ? !cityId.equals(user.cityId) : user.cityId != null) return false;
        if (createdAt != null ? !createdAt.equals(user.createdAt) : user.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByMadeBy")
    public List<AdvertComments> getAdvertCommentsById() {
        return advertCommentsById;
    }

    public void setAdvertCommentsById(List<AdvertComments> advertCommentsById) {
        this.advertCommentsById = advertCommentsById;
    }

    @OneToMany(mappedBy = "userByOwnerId")
    public List<Advertisement> getAdvertisementsById() {
        return advertisementsById;
    }

    public void setAdvertisementsById(List<Advertisement> advertisementsById) {
        this.advertisementsById = advertisementsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public List<FavoriteAd> getFavoriteAdsById() {
        return favoriteAdsById;
    }

    public void setFavoriteAdsById(List<FavoriteAd> favoriteAdsById) {
        this.favoriteAdsById = favoriteAdsById;
    }

    @OneToMany(mappedBy = "userBySender")
    public List<Message> getMessagesById() {
        return messagesById;
    }

    public void setMessagesById(List<Message> messagesById) {
        this.messagesById = messagesById;
    }

    @OneToMany(mappedBy = "userByReceiver")
    public List<Message> getMessagesById_0() {
        return messagesById_0;
    }

    public void setMessagesById_0(List<Message> messagesById_0) {
        this.messagesById_0 = messagesById_0;
    }

    @OneToMany(mappedBy = "userByMadeBy")
    public List<ProfileComments> getProfileCommentsById() {
        return profileCommentsById;
    }

    public void setProfileCommentsById(List<ProfileComments> profileCommentsById) {
        this.profileCommentsById = profileCommentsById;
    }

    @OneToMany(mappedBy = "userByMadeFor")
    public List<ProfileComments> getProfileCommentsById_0() {
        return profileCommentsById_0;
    }

    public void setProfileCommentsById_0(List<ProfileComments> profileCommentsById_0) {
        this.profileCommentsById_0 = profileCommentsById_0;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }
}

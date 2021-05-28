package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    private String username;
    private String password;
    private Timestamp createdAt;
    @JsonIgnore
    private List<AdvertComments> advertCommentsById;
    @JsonIgnore
    private List<Advertisement> advertisementsById;
    @JsonIgnore
    private List<FavoriteAd> favoriteAds;
    @JsonIgnore
    private List<Message> sentMessages;
    @JsonIgnore
    private List<Message> receivedMessages;
    @JsonIgnore
    private List<ProfileComments> profileCommentsMade;
    @JsonIgnore
    private List<ProfileComments> profileCommentsSent;
    private City city;
    @JsonIgnore
    private Picture picture;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
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
//        if (cityId != null ? !cityId.equals(user.cityId) : user.cityId != null) return false;
        if (createdAt != null ? !createdAt.equals(user.createdAt) : user.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phone, username, password, createdAt, advertCommentsById, advertisementsById, favoriteAds, sentMessages, receivedMessages, profileCommentsMade, profileCommentsSent, city, picture);
    }

    @OneToMany(mappedBy = "madeBy")
    public List<AdvertComments> getAdvertCommentsById() {
        return advertCommentsById;
    }

    public void setAdvertCommentsById(List<AdvertComments> advertCommentsById) {
        this.advertCommentsById = advertCommentsById;
    }

    @OneToMany(mappedBy = "owner")
    public List<Advertisement> getAdvertisementsById() {
        return advertisementsById;
    }

    public void setAdvertisementsById(List<Advertisement> advertisementsById) {
        this.advertisementsById = advertisementsById;
    }

    @OneToMany(mappedBy = "user")
    public List<FavoriteAd> getFavoriteAds() {
        return favoriteAds;
    }

    public void setFavoriteAds(List<FavoriteAd> favoriteAds) {
        this.favoriteAds = favoriteAds;
    }

    @OneToMany(mappedBy = "userBySender")
    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    @OneToMany(mappedBy = "userByReceiver")
    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    @OneToMany(mappedBy = "madeBy")
    public List<ProfileComments> getProfileCommentsMade() {
        return profileCommentsMade;
    }

    public void setProfileCommentsMade(List<ProfileComments> profileCommentsById) {
        this.profileCommentsMade = profileCommentsById;
    }

    @OneToMany(mappedBy = "madeFor")
    public List<ProfileComments> getProfileCommentsSent() {
        return profileCommentsSent;
    }

    public void setProfileCommentsSent(List<ProfileComments> profileCommentsById_0) {
        this.profileCommentsSent = profileCommentsById_0;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "id="+id;
    }
}



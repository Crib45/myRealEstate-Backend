package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Estate {
    private Long id;
    private Integer size;
    private Timestamp createdAt;
    @JsonIgnore
    private Advertisement advertisement;
    private City city;
    private SubCategory subCategory;
    @JsonIgnore
    private List<UtilityEstate> utilityEstate;

    @Id
    @Column(name = "advertisement_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "size")
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }




    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
//    @JoinColumn(name = "advertisement_id", referencedColumnName = "id")
    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id")
    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    @OneToMany(mappedBy = "estate")
    public List<UtilityEstate> getUtilityEstate() {
        return utilityEstate;
    }

    public void setUtilityEstate(List<UtilityEstate> utilityEstate) {
        this.utilityEstate = utilityEstate;
    }
}

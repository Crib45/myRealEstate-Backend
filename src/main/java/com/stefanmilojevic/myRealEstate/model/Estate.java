package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Estate {
    private int id;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estate estate = (Estate) o;

        if (id != estate.id) return false;
        if (size != null ? !size.equals(estate.size) : estate.size != null) return false;
        if (createdAt != null ? !createdAt.equals(estate.createdAt) : estate.createdAt != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
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

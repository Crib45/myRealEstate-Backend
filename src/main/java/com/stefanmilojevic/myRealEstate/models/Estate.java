package com.stefanmilojevic.myRealEstate.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
public class Estate {
    private int id;
    private Integer size;
    private Timestamp createdAt;
    private Integer advertisementId;
    private Integer cityId;
    private Integer subCategoryId;
    private Advertisement advertisementByAdvertisementId;
    private City cityByCityId;
    private SubCategory subCategoryBySubCategoryId;
    private List<UtilityEstate> utilityEstatesById;

    @Id
    @Column(name = "id")
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
        if (advertisementId != null ? !advertisementId.equals(estate.advertisementId) : estate.advertisementId != null)
            return false;
        if (cityId != null ? !cityId.equals(estate.cityId) : estate.cityId != null) return false;
        if (subCategoryId != null ? !subCategoryId.equals(estate.subCategoryId) : estate.subCategoryId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (advertisementId != null ? advertisementId.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (subCategoryId != null ? subCategoryId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "advertisement_id", referencedColumnName = "id")
    public Advertisement getAdvertisementByAdvertisementId() {
        return advertisementByAdvertisementId;
    }

    public void setAdvertisementByAdvertisementId(Advertisement advertisementByAdvertisementId) {
        this.advertisementByAdvertisementId = advertisementByAdvertisementId;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id")
    public SubCategory getSubCategoryBySubCategoryId() {
        return subCategoryBySubCategoryId;
    }

    public void setSubCategoryBySubCategoryId(SubCategory subCategoryBySubCategoryId) {
        this.subCategoryBySubCategoryId = subCategoryBySubCategoryId;
    }

    @OneToMany(mappedBy = "estateByEstateId")
    public List<UtilityEstate> getUtilityEstatesById() {
        return utilityEstatesById;
    }

    public void setUtilityEstatesById(List<UtilityEstate> utilityEstatesById) {
        this.utilityEstatesById = utilityEstatesById;
    }
}

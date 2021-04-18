package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "utility_estate", schema = "myrealestate", catalog = "")
public class UtilityEstate {
    private int id;
    private Integer value;
    @JsonBackReference(value = "utilityEstate-estate")
    private Estate estateByEstateId;
    @JsonBackReference(value = "utilityestate-utility")
    private Utility utilityByUtilityId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UtilityEstate that = (UtilityEstate) o;

        if (id != that.id) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "estate_id", referencedColumnName = "id")
    public Estate getEstateByEstateId() {
        return estateByEstateId;
    }

    public void setEstateByEstateId(Estate estateByEstateId) {
        this.estateByEstateId = estateByEstateId;
    }

    @ManyToOne
    @JoinColumn(name = "utility_id", referencedColumnName = "id")
    public Utility getUtilityByUtilityId() {
        return utilityByUtilityId;
    }

    public void setUtilityByUtilityId(Utility utilityByUtilityId) {
        this.utilityByUtilityId = utilityByUtilityId;
    }
}

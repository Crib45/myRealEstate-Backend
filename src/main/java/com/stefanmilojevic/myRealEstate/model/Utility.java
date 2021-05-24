package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Utility {
    private int id;
    private String name;
    private String icon;
    @JsonIgnore
    private List<SubCategory> subCategory;
    @JsonIgnore
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utility utility = (Utility) o;

        if (id != utility.id) return false;
        if (name != null ? !name.equals(utility.name) : utility.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "sub_category_id", referencedColumnName = "id")
    @ManyToMany(mappedBy = "utilities", fetch = FetchType.LAZY)
    public List<SubCategory> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<SubCategory> subCategory) {
        this.subCategory = subCategory;
    }

    @OneToMany(mappedBy = "utilityByUtilityId")
    public List<UtilityEstate> getUtilityEstatesById() {
        return utilityEstatesById;
    }

    public void setUtilityEstatesById(List<UtilityEstate> utilityEstatesById) {
        this.utilityEstatesById = utilityEstatesById;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

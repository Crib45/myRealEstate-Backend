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
    private SubCategory subCategoryBySubCategoryId;
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

    @ManyToOne
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id")
    public SubCategory getSubCategoryBySubCategoryId() {
        return subCategoryBySubCategoryId;
    }

    public void setSubCategoryBySubCategoryId(SubCategory subCategoryBySubCategoryId) {
        this.subCategoryBySubCategoryId = subCategoryBySubCategoryId;
    }

    @OneToMany(mappedBy = "utilityByUtilityId")
    public List<UtilityEstate> getUtilityEstatesById() {
        return utilityEstatesById;
    }

    public void setUtilityEstatesById(List<UtilityEstate> utilityEstatesById) {
        this.utilityEstatesById = utilityEstatesById;
    }
}

package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Utility {
    private int id;
    private String name;
    @JsonBackReference(value = "subcategory-utility")
    private SubCategory subCategoryBySubCategoryId;
    @JsonManagedReference(value = "utilityestate-utility")
    private Collection<UtilityEstate> utilityEstatesById;

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
    public Collection<UtilityEstate> getUtilityEstatesById() {
        return utilityEstatesById;
    }

    public void setUtilityEstatesById(Collection<UtilityEstate> utilityEstatesById) {
        this.utilityEstatesById = utilityEstatesById;
    }
}

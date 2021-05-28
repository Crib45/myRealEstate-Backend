package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Utility {
    private Long id;
    private String name;
    private String icon;
    @JsonIgnore
    private List<SubCategory> subCategory;
    @JsonIgnore
    private List<UtilityEstate> utilityEstatesById;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @OneToMany(mappedBy = "utility")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utility utility = (Utility) o;
        return id.equals(utility.id) && Objects.equals(name, utility.name) && Objects.equals(icon, utility.icon) && Objects.equals(subCategory, utility.subCategory) && Objects.equals(utilityEstatesById, utility.utilityEstatesById);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, icon, subCategory, utilityEstatesById);
    }
}

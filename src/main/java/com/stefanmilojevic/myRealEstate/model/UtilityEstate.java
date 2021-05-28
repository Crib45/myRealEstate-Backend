package com.stefanmilojevic.myRealEstate.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "utility_estate", schema = "myrealestate", catalog = "")
public class UtilityEstate {
    private Long id;
    private Boolean value;
    private Estate estate;
    private Utility utility;
    private String description;

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
    @Column(name = "value", columnDefinition = "TINYINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @ManyToOne
    @JoinColumn(name = "estate_id", referencedColumnName = "advertisement_id")
    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    @ManyToOne
    @JoinColumn(name = "utility_id", referencedColumnName = "id")
    public Utility getUtility() {
        return utility;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilityEstate that = (UtilityEstate) o;
        return id.equals(that.id) && Objects.equals(value, that.value) && Objects.equals(description, that.description)
                && estate.equals(that.estate) && utility.equals(that.utility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, estate, utility, description);
    }

    @Override
    public String toString() {
        return "UtilityEstate{" +
                "id=" + id +
                ", value=" + value +
                ", estate=" + estate +
                ", utility=" + utility +
                '}';
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

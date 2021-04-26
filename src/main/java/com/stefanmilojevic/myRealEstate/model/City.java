package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {
    private int id;
    private String name;
    private String description;
    private Integer population;
    @JsonManagedReference(value = "estate-city")
    private List<Estate> estatesById;
    @JsonManagedReference(value = "user-city")
    private List<User> users;

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

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "population")
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (description != null ? !description.equals(city.description) : city.description != null) return false;
        if (population != null ? !population.equals(city.population) : city.population != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cityByCityId", fetch = FetchType.LAZY)
    public List<Estate> getEstatesById() {
        return estatesById;
    }

    public void setEstatesById(List<Estate> estatesById) {
        this.estatesById = estatesById;
    }

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

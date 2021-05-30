package com.stefanmilojevic.myRealEstate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "saved_filter", schema = "myrealestate", catalog = "")
public class SavedFilter {
    private Long id;
    private Integer maxSize;
    private Integer maxPrice;
    private Category category;
    private User user;
    private Timestamp lastChecked;

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
    @Column(name = "max_size")
    public Integer getMaxSize() {
        return maxSize;
    }


    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    @Basic
    @Column(name = "max_price")
    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "last_checked")
    public Timestamp getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(Timestamp lastChecked) {
        this.lastChecked = lastChecked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavedFilter that = (SavedFilter) o;
        return id.equals(that.id) && Objects.equals(maxSize, that.maxSize) && Objects.equals(maxPrice, that.maxPrice) && Objects.equals(category, that.category) && Objects.equals(user, that.user) && Objects.equals(lastChecked, that.lastChecked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maxSize, maxPrice, category, user, lastChecked);
    }

    @Override
    public String toString() {
        return "SavedFilter{" +
                "id=" + id +
                ", maxSize=" + maxSize +
                ", maxPrice=" + maxPrice +
                ", category=" + category +
                ", user=" + user +
                ", lastChecked=" + lastChecked +
                '}';
    }
}

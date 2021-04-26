package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "profile_comments", schema = "myrealestate", catalog = "")
public class ProfileComments {
    private int id;
    private Integer madeBy;
    private Integer madeFor;
    private String comment;
    private Double grade;
    private Timestamp createdAt;
    @JsonIgnore
    private User userByMadeBy;
    @JsonIgnore
    private User userByMadeFor;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "grade")
    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
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

        ProfileComments that = (ProfileComments) o;

        if (id != that.id) return false;
        if (madeBy != null ? !madeBy.equals(that.madeBy) : that.madeBy != null) return false;
        if (madeFor != null ? !madeFor.equals(that.madeFor) : that.madeFor != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (madeBy != null ? madeBy.hashCode() : 0);
        result = 31 * result + (madeFor != null ? madeFor.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "made_by", referencedColumnName = "id")
    public User getUserByMadeBy() {
        return userByMadeBy;
    }

    public void setUserByMadeBy(User userByMadeBy) {
        this.userByMadeBy = userByMadeBy;
    }

    @ManyToOne
    @JoinColumn(name = "made_for", referencedColumnName = "id")
    public User getUserByMadeFor() {
        return userByMadeFor;
    }

    public void setUserByMadeFor(User userByMadeFor) {
        this.userByMadeFor = userByMadeFor;
    }
}

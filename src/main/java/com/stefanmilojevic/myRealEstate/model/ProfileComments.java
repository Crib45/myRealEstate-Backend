package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "profile_comments", schema = "myrealestate", catalog = "")
public class ProfileComments {
    private int id;
    private String comment;
    private Double grade;
    private Timestamp createdAt;
    private User madeBy;
    private User madeFor;
    private Boolean seen = false;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "seen",nullable = false, columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
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
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "made_by", referencedColumnName = "id")
    public User getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(User userByMadeBy) {
        this.madeBy = userByMadeBy;
    }

    @ManyToOne
    @JoinColumn(name = "made_for", referencedColumnName = "id")
    public User getMadeFor() {
        return madeFor;
    }

    public void setMadeFor(User userByMadeFor) {
        this.madeFor = userByMadeFor;
    }

    @Override
    public String toString() {
        return "ProfileComments{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", grade=" + grade +
                ", createdAt=" + createdAt +
                ", madeBy=" + madeBy +
                ", madeFor=" + madeFor +
                '}';
    }
}

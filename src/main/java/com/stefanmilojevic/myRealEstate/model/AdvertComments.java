package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "advert_comments", schema = "myrealestate", catalog = "")
public class AdvertComments {
    private int id;
    private Integer quote;
    private String comment;
    private Timestamp createdAt;
    private User madeBy;
    private Advertisement advertisement;
    private AdvertComments advertCommentsByQuote;
    // Replies to advert-comment
    @JsonIgnore
    private List<AdvertComments> advertCommentsById;


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

        AdvertComments that = (AdvertComments) o;

        if (id != that.id) return false;
        if (madeBy != null ? !madeBy.equals(that.madeBy) : that.madeBy != null) return false;
//        if (advertisementId != null ? !advertisementId.equals(that.advertisementId) : that.advertisementId != null)
//            return false;
        if (quote != null ? !quote.equals(that.quote) : that.quote != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (madeBy != null ? madeBy.hashCode() : 0);
//        result = 31 * result + (advertisementId != null ? advertisementId.hashCode() : 0);
        result = 31 * result + (quote != null ? quote.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "made_by", referencedColumnName = "id")
    public User getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(User madeBy) {
        this.madeBy = madeBy;
    }

    @ManyToOne
    @JoinColumn(name = "advertisement_id", referencedColumnName = "id")
    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    @ManyToOne
    @JoinColumn(name = "quote", referencedColumnName = "id")
    public AdvertComments getAdvertCommentsByQuote() {
        return advertCommentsByQuote;
    }

    public void setAdvertCommentsByQuote(AdvertComments advertCommentsByQuote) {
        this.advertCommentsByQuote = advertCommentsByQuote;
    }

    @OneToMany(mappedBy = "advertCommentsByQuote")
    public List<AdvertComments> getAdvertCommentsById() {
        return advertCommentsById;
    }

    public void setAdvertCommentsById(List<AdvertComments> advertCommentsById) {
        this.advertCommentsById = advertCommentsById;
    }
}

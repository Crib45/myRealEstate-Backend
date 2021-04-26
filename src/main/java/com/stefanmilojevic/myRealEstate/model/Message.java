package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Message {
    private int id;
    private String content;
    private Byte seen;
    private Timestamp createdAt;
    private User userBySender;
    private User userByReceiver;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "seen")
    public Byte getSeen() {
        return seen;
    }

    public void setSeen(Byte seen) {
        this.seen = seen;
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

        Message message = (Message) o;

        if (id != message.id) return false;
        if (content != null ? !content.equals(message.content) : message.content != null) return false;
        if (seen != null ? !seen.equals(message.seen) : message.seen != null) return false;
        if (createdAt != null ? !createdAt.equals(message.createdAt) : message.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (seen != null ? seen.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sender", referencedColumnName = "id")
    public User getUserBySender() {
        return userBySender;
    }

    public void setUserBySender(User userBySender) {
        this.userBySender = userBySender;
    }

    @ManyToOne
    @JoinColumn(name = "receiver", referencedColumnName = "id")
    public User getUserByReceiver() {
        return userByReceiver;
    }

    public void setUserByReceiver(User userByReceiver) {
        this.userByReceiver = userByReceiver;
    }
}

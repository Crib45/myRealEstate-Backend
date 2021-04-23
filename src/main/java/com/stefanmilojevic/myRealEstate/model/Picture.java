package com.stefanmilojevic.myRealEstate.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;
import java.util.Objects;

@Entity
public class Picture {
    private int id;
    private String title;
    private String caption;
    private Blob imgBlob;
    @JsonManagedReference(value = "category-picture")
    private List<Category> categoryList;
    private String fileName;
    private String contentType;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "caption")
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Basic
    @Column(name = "filename")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "content_type")
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Lob
    @Column(name = "imgBlob")
    public Blob getImgBlob() {
        return imgBlob;
    }

    public void setImgBlob(Blob imgBlob) {
        this.imgBlob = imgBlob;
    }

    @OneToMany(mappedBy = "pictureById")
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return id == picture.id && Objects.equals(title, picture.title)
                && Objects.equals(caption, picture.caption)
                && Objects.equals(imgBlob, picture.imgBlob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, caption, imgBlob);
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", caption='" + caption + '\'' +
                ", imgBlob=" + imgBlob +
                '}';
    }


}

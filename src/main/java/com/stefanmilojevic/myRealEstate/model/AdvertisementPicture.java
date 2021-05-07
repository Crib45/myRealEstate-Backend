package com.stefanmilojevic.myRealEstate.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "advertisement_picture", schema = "myrealestate", catalog = "")
public class AdvertisementPicture {
    private int id;
    private String fileName;
    private byte[] fileData;
    private String contentType;
    private Advertisement advertisement;
    private Boolean primaryPic;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "file_name")
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
    @Column(name = "file_data")
    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    @ManyToOne
    @JoinColumn(name = "advertisement_id", referencedColumnName = "id")
    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    @Basic
    @Column(name = "primary_pic", columnDefinition = "TINYINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public Boolean getPrimaryPic() {
        return primaryPic;
    }

    public void setPrimaryPic(Boolean primaryPic) {
        this.primaryPic = primaryPic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvertisementPicture that = (AdvertisementPicture) o;
        return id == that.id && Objects.equals(fileName, that.fileName) && Arrays.equals(fileData, that.fileData) && Objects.equals(contentType, that.contentType) && Objects.equals(advertisement, that.advertisement) && Objects.equals(primaryPic, that.primaryPic);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, fileName, contentType, advertisement, primaryPic);
        result = 31 * result + Arrays.hashCode(fileData);
        return result;
    }

    @Override
    public String toString() {
        return "AdvertisementPicture{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileData=" + Arrays.toString(fileData) +
                ", contentType='" + contentType + '\'' +
                ", advertisement=" + advertisement +
                ", primaryPic=" + primaryPic +
                '}';
    }


}

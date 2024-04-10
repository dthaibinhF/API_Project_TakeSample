package com.example.api_takesample.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Picture {
    @Id
    @SequenceGenerator(
            name = "picture_sequence",
            sequenceName = "picture_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "picture_sequence"
    )
    private Long idPicture;
    private String namePicture;
    private String describe;
    private String url;

    public Picture() {
    }

    public Picture(Long idPicture, String namePicture, String describe, String url) {
        this.idPicture = idPicture;
        this.namePicture = namePicture;
        this.describe = describe;
        this.url = url;
    }

    public Picture(String namePicture, String describe, String url) {
        this.namePicture = namePicture;
        this.describe = describe;
        this.url = url;
    }

    public Long getIdPicture() {
        return idPicture;
    }

    public String getNamePicture() {
        return namePicture;
    }

    public void setNamePicture(String namePicture) {
        this.namePicture = namePicture;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

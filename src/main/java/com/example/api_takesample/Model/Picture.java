package com.example.api_takesample.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
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

    @ManyToOne
    @JoinColumn(name = "sample_id")
    @JsonIgnoreProperties({"pictures", "forms", "project"})
    private Sample sample;

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

    public Picture(String namePicture, String describe, String url, Sample sample) {
        this.namePicture = namePicture;
        this.describe = describe;
        this.url = url;
        this.sample = sample;
    }

    public void setNamePicture(String namePicture) {
        this.namePicture = namePicture;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIdPicture(Long idPicture) {
        this.idPicture = idPicture;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }
}

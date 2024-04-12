package com.example.api_takesample.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@Table
public class Sample {
    @Id
    @SequenceGenerator(
            name = "sample_sequence",
            sequenceName = "sample_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "sample_sequence"
    )
    private Long idSample;
    private String nameSample;
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnoreProperties({"samples", "users", "tasks"})
    private Project project;

    @OneToMany(mappedBy = "sample")
    @JsonIgnoreProperties("sample")
    private List<Picture> pictures;

    @OneToMany(mappedBy = "sample")
    @JsonIgnoreProperties("sample")
    private List<Form> forms;


    public Sample() {
    }

    public Sample(Long idSample, String nameSample, LocalDate createDate) {
        this.idSample = idSample;
        this.nameSample = nameSample;
        this.createDate = createDate;
    }

    public Sample(String nameSample, LocalDate createDate) {
        this.nameSample = nameSample;
        this.createDate = createDate;
    }

    public Sample(String nameSample, LocalDate createDate, Project project) {
        this.nameSample = nameSample;
        this.createDate = createDate;
        this.project = project;
    }

    public void setNameSample(String nameSample) {
        this.nameSample = nameSample;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setIdSample(Long idSample) {
        this.idSample = idSample;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }


}

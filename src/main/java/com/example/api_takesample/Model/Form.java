package com.example.api_takesample.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table
public class Form {
    @Id
    @SequenceGenerator(
            name = "form_sequence",
            sequenceName = "form_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "form_sequence"
    )
    private Long idForm;
    private String nameForm;
    private LocalDate createDate;
    private String url;

    @ManyToOne
    @JoinColumn(name = "sample_id")
    @JsonIgnoreProperties({"forms", "project", "pictures"})
    private Sample sample;

    public Form() {

    }

    public Form(Long idForm, String nameForm, LocalDate createDate, String url) {
        this.idForm = idForm;
        this.nameForm = nameForm;
        this.createDate = createDate;
        this.url = url;
    }

    public Form(String nameForm, LocalDate createDate, String url) {
        this.nameForm = nameForm;
        this.createDate = createDate;
        this.url = url;
    }

    public Form(String nameForm, LocalDate createDate, String url, Sample sample) {
        this.nameForm = nameForm;
        this.createDate = createDate;
        this.url = url;
        this.sample = sample;
    }

    public void setNameForm(String nameForm) {
        this.nameForm = nameForm;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIdForm(Long idForm) {
        this.idForm = idForm;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }
}

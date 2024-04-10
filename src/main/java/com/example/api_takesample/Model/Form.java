package com.example.api_takesample.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    public Long getIdForm() {
        return idForm;
    }

    public String getNameForm() {
        return nameForm;
    }

    public void setNameForm(String nameForm) {
        this.nameForm = nameForm;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

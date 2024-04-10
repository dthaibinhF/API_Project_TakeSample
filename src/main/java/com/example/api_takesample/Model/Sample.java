package com.example.api_takesample.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    public Long getIdSample() {
        return idSample;
    }

    public String getNameSample() {
        return nameSample;
    }

    public void setNameSample(String nameSample) {
        this.nameSample = nameSample;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}

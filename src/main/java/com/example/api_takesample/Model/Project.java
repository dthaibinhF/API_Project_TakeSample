package com.example.api_takesample.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Project {
    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "project_sequence"
    )
    private Long idProject;
    private String projectName;
    private String researchMethod; //phuong phap nghien cuu
    private String describe;
    private LocalDate dateCreate;

    public Project() {
    }

    public Project(Long idProject, String projectName, String researchMethod, String describe, LocalDate dateCreate) {
        this.idProject = idProject;
        this.projectName = projectName;
        this.researchMethod = researchMethod;
        this.describe = describe;
        this.dateCreate = dateCreate;
    }

    public Project(String projectName, String researchMethod, String describe, LocalDate dateCreate) {
        this.projectName = projectName;
        this.researchMethod = researchMethod;
        this.describe = describe;
        this.dateCreate = dateCreate;
    }

    public Long getIdProject() {
        return idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getResearchMethod() {
        return researchMethod;
    }

    public void setResearchMethod(String researchMethod) {
        this.researchMethod = researchMethod;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }
}

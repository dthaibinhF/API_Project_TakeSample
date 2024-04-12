package com.example.api_takesample.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
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

    @ManyToMany(mappedBy = "projects")
    @JsonIgnoreProperties("projects")
    private List<User> users;

    @OneToMany(mappedBy = "project")
    @JsonIgnoreProperties("project")
    private List<Task> tasks;

    @OneToMany(mappedBy = "project")
    @JsonIgnoreProperties("project")
    private List<Sample> samples;

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

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setResearchMethod(String researchMethod) {
        this.researchMethod = researchMethod;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setSamples(List<Sample> samples) {
        this.samples = samples;
    }
}

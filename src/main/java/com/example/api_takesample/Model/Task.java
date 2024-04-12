package com.example.api_takesample.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "task_sequence"
    )
    private Long idTask;
    private LocalDate startTime;
    private LocalDate deadline;
    private String direction; //describe the job

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnoreProperties({"tasks", "users", "samples"})
    private Project project;

    public Task() {
    }

    public Task(Long idTask, LocalDate startTime, LocalDate deadline, String direction) {
        this.idTask = idTask;
        this.startTime = startTime;
        this.deadline = deadline;
        this.direction = direction;
    }

    public Task(LocalDate startTime, LocalDate deadline, String direction) {
        this.startTime = startTime;
        this.deadline = deadline;
        this.direction = direction;
    }

    public Task(LocalDate startTime, LocalDate deadline, String direction, Project project) {
        this.startTime = startTime;
        this.deadline = deadline;
        this.direction = direction;
        this.project = project;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

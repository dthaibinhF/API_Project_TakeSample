package com.example.api_takesample.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    public Long getIdTask() {
        return idTask;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}

package com.example.api_takesample.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "user_api")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "user_sequence"
    )
    @Column(name = "idUser")
    private Long idUser;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "idAccount")
    private Account account;

    @ManyToMany
    @JoinTable(
            name = "participate",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "projects_id")
    )
    @JsonIgnoreProperties({"users", "samples", "tasks"})
    private List<Project> projects;

    public User() {
    }

    public User(String name, String address, String email, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(String name, String address, String email, String phoneNumber, Account account) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public User(String name, String address, String email, String phoneNumber, Account account, List<Project> projects) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.account = account;
        this.projects = projects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

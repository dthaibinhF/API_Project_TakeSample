package com.example.api_takesample.Model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long idAccount;
    @Column(unique = true)
    private String username;
    private String password;

    public Account() {
    }

    public Account(Long idAccount, String username, String password) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }
}

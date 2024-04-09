package com.example.api_takesample.Repository;

import com.example.api_takesample.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository
        extends JpaRepository<Account, Long> {

    //SELECT * FROM account WHERE email = ?
    @Query("SELECT a FROM Account a WHERE a.username = ?1")
    Optional<Account> findByUsername(String username);

}

package com.example.api_takesample.Configuration;

import com.example.api_takesample.Model.Account;
import com.example.api_takesample.Model.User;
import com.example.api_takesample.Repository.AccountRepository;
import com.example.api_takesample.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    CommandLineRunner commandLineRunner(
            AccountRepository accountRepository,
            UserRepository userRepository) {
        return args -> {
            Account first = new Account(
                    "0939464077",
                    "1232"
            );

            Account second = new Account(
                    "093946405",
                    "123255"
            );

            Account third = new Account(
                    "093946505",
                    "123257"
            );

            accountRepository.saveAll(
                    List.of(first, second,third)
            );

            User a = new User(
                    "Dang Thai Binh",
                    "Can Tho",
                    "dthaibinh03@gmail.com",
                    "0939464077"
            );

            userRepository.saveAll(
                    List.of(a)
            );

        };
    }
}

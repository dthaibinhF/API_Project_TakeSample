package com.example.api_takesample.Configuration;

import com.example.api_takesample.Model.Account;
import com.example.api_takesample.Model.Project;
import com.example.api_takesample.Model.Task;
import com.example.api_takesample.Model.User;
import com.example.api_takesample.Repository.AccountRepository;
import com.example.api_takesample.Repository.ProjectRepository;
import com.example.api_takesample.Repository.TaskRepository;
import com.example.api_takesample.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    CommandLineRunner commandLineRunner(
            AccountRepository accountRepository,
            UserRepository userRepository,
            ProjectRepository projectRepository,
            TaskRepository taskRepository) {
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

            Project test = new Project(
                    "take sample",
                    "thu nghiem lam san",
                    "chat tay",
                    LocalDate.of(2024, Month.APRIL, 6)
            );

            projectRepository.saveAll(
                    List.of(test)
            );

            Task task1 = new Task(
                    LocalDate.of(2024, Month.APRIL, 7),
                    LocalDate.of(2024, Month.APRIL, 10),
                    "Complete the API"
            );

            Task task2 = new Task(
                    LocalDate.of(2024, Month.APRIL, 13),
                    LocalDate.of(2024, Month.APRIL, 18),
                    "Complete the Interface"
            );

            taskRepository.saveAll(
                    List.of(task1, task2)
            );

        };
    }
}

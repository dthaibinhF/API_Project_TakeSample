package com.example.api_takesample.Configuration;

import com.example.api_takesample.Model.*;
import com.example.api_takesample.Repository.*;
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
            TaskRepository taskRepository,
            PictureRepository pictureRepository,
            FormRepository formRepository,
            SampleRepository sampleRepository) {
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

            Picture pic1 = new Picture(
                    "anh 1",
                    "cay a",
                    "https//:ascascsc"
            );

            Picture pic2 = new Picture(
                    "anh 2",
                    "cay C",
                    "https//:abcdef"
            );

            pictureRepository.saveAll(
                    List.of(
                            pic1, pic2
                    )
            );

            Form form1 = new Form(
                    "thu thap yeu cau",
                    LocalDate.of(2024, Month.APRIL, 1),
                    "https//:asasd"
            );

            Form form2 = new Form(
                    "thu thap yeu cau",
                    LocalDate.of(2024, Month.MARCH, 1),
                    "https//:asasd"
            );

            formRepository.saveAll(
                    List.of(
                            form1,form2
                    )
            );

            Sample sample1 = new Sample(
                    "Mau cay trong",
                    LocalDate.of(2024, Month.JANUARY, 1)
            );

            Sample sample2 = new Sample(
                    "Mau cay lua",
                    LocalDate.of(2024, Month.FEBRUARY, 1)
            );

            sampleRepository.saveAll(
                    List.of(
                            sample1, sample2
                    )
            );
        };
    }
}

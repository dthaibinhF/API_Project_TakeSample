package com.example.api_takesample.Configuration;

import com.example.api_takesample.Model.*;
import com.example.api_takesample.Repository.*;
import org.apache.tomcat.Jar;
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
            Account ac1 = new Account(
                    "0939464077",
                    "1232456"
            );

            Account ac2 = new Account(
                    "0111111111",
                    "1232456"
            );

            Account ac3 = new Account(
                    "0222222222",
                    "1232456"
            );

            Account ac4 = new Account(
                    "0333333333",
                    "1232456"
            );
            Account ac5 = new Account(
                    "0444444444",
                    "1232456"
            );
            Account ac6 = new Account(
                    "0555555555",
                    "1232456"
            );

            //user

            User user1 = new User(
                    "Thai Binh",
                    "binh@gmail.com",
                    "Ninh kieu, Can Tho",
                    "0939464077",
                    ac1
            );

            User user2 = new User(
                    "Hoai Bao",
                    "bao@gmail.com",
                    "Binh Thuy, Can Tho",
                    "0111111111",
                    ac2
            );

            User user3 = new User(
                    "Huynh Nhu",
                    "nhu@gmail.com",
                    "Cai Rang, Can Tho",
                    "0222222222",
                    ac3
            );

            User user4 = new User(
                    "Phi Nhut",
                    "nhut@gmail.com",
                    "Ho Chi Minh",
                    "0333333333",
                    ac4
            );

            User user5 = new User(
                    "John",
                    "john@gmail.com",
                    "California",
                    "0444444444",
                    ac5
            );

            User user6 = new User(
                    "Maria",
                    "maria@gmail.com",
                    "Florida",
                    "0555555555",
                    ac6
            );

            //project
            Project project1 = new Project(
                    "Climate Change",
                    "Carbon Concentration",
                    "make big change",
                    LocalDate.of(2024, Month.JANUARY, 20)
            );

            Project project2 = new Project(
                    "Sea Level Rise",
                    "The high in multiple area",
                    "the problem causing flood",
                    LocalDate.of(2023, Month.OCTOBER, 25)
            );

            //Task

            Task task1 = new Task(
                    LocalDate.of(2024, Month.JANUARY, 20),
                    LocalDate.of(2024, Month.JANUARY, 30),
                    "Research problem",
                    project1
            );

            Task task2 = new Task(
                    LocalDate.of(2024, Month.JANUARY, 23),
                    LocalDate.of(2024, Month.JANUARY, 27),
                    "Create goals",
                    project1
            );

            Task task3 = new Task(
                    LocalDate.of(2024, Month.JANUARY, 30),
                    LocalDate.of(2024, Month.FEBRUARY, 3),
                    "Presentation the problem and goal",
                    project1
            );

            Task task4 = new Task(
                    LocalDate.of(2023, Month.OCTOBER, 26),
                    LocalDate.of(2023, Month.OCTOBER, 30),
                    "Research why sea-level rise",
                    project2
            );

            Task task5 = new Task(
                    LocalDate.of(2023, Month.NOVEMBER, 1),
                    LocalDate.of(2023, Month.NOVEMBER, 5),
                    "Interview",
                    project2
            );

            //SAMPLE
            Sample sample1 = new Sample(
                    "Ozon Damage",
                    LocalDate.of(2024, Month.JANUARY, 23),
                    project1
            );

            Sample sample2 = new Sample(
                    "Drought at India",
                    LocalDate.of(2024, Month.JANUARY, 25),
                    project1
            );

            Sample sample3 = new Sample(
                    "Flood at Japan",
                    LocalDate.of(2023, Month.OCTOBER, 25),
                    project2
            );

            Sample sample4 = new Sample(
                    "Flood at Vietnam",
                    LocalDate.of(2023, Month.OCTOBER, 26),
                    project2
            );

            //PICTURE

            Picture pic1 = new Picture(
                    "Ozon picture",
                    "see how big is it",
                    "https://somthing1",
                    sample1
            );

            Picture pic2 = new Picture(
                    "Image01",
                    "see how ozom effect environment",
                    "https://somthing12",
                    sample1
            );

            Picture pic3 = new Picture(
                    "people in flood",
                    "https://japan1",
                    "see how people suffer",
                    sample3
            );
            Picture pic4 = new Picture(
                    "hunger",
                    "people starving",
                    "https://india1",
                    sample2
            );

            //FORM

            Form form1 = new Form(
                    "percent ozon damege through year",
                    LocalDate.parse("2024-01-28"),
                    "https://form/ozon",
                    sample1
            );

            Form form2 = new Form(
                    "How many province or city get flood",
                    LocalDate.parse("2023-11-19"),
                    "https://form/vietnam1",
                    sample4
            );

            Form form3 = new Form(
                    "Survey reason get flood in vietnam",
                    LocalDate.parse("2023-12-10"),
                    "https://form/vietnam2",
                    sample4
            );

            Form form4 = new Form(
                    "Why drought make peopler starv to deadth",
                    LocalDate.parse("2024-03-14"),
                    "https://form/india",
                    sample2
            );

            //Save
            userRepository.saveAll(
                    List.of(user1, user2, user3, user4,user5, user6)
            );

            accountRepository.saveAll(
                    List.of(ac1, ac2,ac3,ac4,ac5,ac6)
            );

            projectRepository.saveAll(
                    List.of(project1, project2)
            );

            taskRepository.saveAll(
                    List.of(task1, task2, task3, task4, task5)
            );

            sampleRepository.saveAll(
                    List.of(sample1, sample2, sample3, sample4)
            );

            pictureRepository.saveAll(
                    List.of(pic1, pic2, pic3, pic4)
            );

            formRepository.saveAll(
                    List.of(form1, form2, form3, form4)
            );
        };
    }
}

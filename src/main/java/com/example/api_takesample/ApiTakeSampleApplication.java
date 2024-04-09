package com.example.api_takesample;

import com.example.api_takesample.Model.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class ApiTakeSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTakeSampleApplication.class, args);
    }
}

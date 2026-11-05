package com.example.plantalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PlantaLendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantaLendarApplication.class, args);
    }

}

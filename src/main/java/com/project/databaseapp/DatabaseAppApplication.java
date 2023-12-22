package com.project.databaseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.project.databaseapp.entity")
@ComponentScan(basePackages = "com.project")
public class DatabaseAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseAppApplication.class, args);
        System.out.println("Aplikacja uruchomiona!");
    }
}

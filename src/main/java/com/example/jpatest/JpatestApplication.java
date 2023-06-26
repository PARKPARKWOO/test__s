package com.example.jpatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JpatestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpatestApplication.class, args);
    }

}

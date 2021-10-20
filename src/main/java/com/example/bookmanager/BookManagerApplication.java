package com.example.bookmanager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BookManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookManagerApplication.class, args);
        log.info("Spring boot application started");
    }

}

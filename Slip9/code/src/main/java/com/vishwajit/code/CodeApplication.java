package com.vishwajit.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories("com.vishwajit.code.repository")
@EntityScan("com.vishwajit.code.model")  // Add this if needed
@SpringBootApplication(scanBasePackages = "com.vishwajit.code")
public class CodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeApplication.class, args);
    }
}




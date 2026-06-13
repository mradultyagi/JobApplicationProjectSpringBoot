package com.telusko.soring_boot_rest;

import com.telusko.soring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoringBootRestApplication implements CommandLineRunner {

    @Autowired
    private JobService jobService;

    public static void main(String[] args) {
        SpringApplication.run(SoringBootRestApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("RUN METHOD EXECUTED");
        jobService.load();
    }
}
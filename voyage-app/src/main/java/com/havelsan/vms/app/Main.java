package com.havelsan.vms.app;

import com.havelsan.vms.repository.VoyageRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.havelsan.vms.*"})
@EnableMongoRepositories(basePackageClasses = VoyageRepository.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
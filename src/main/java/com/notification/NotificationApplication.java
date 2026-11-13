package com.notification;

import com.notification.config.NotificationProperties;
import com.notification.service.NotificationDispatcherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(NotificationProperties.class)
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(NotificationDispatcherService dispatcherService) {
        return args -> {
            System.out.println("\n--- STARTING NOTIFICATION DISPATCH DEMO ---");
            dispatcherService.dispatch("email", "user@example.com", "Hello from Java 17 Spring Boot!");
            System.out.println("--- DEMO COMPLETED ---\n");
        };
    }
}
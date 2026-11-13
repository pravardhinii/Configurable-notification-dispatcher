# Configurable Notification Dispatcher

A Spring Boot 3 enterprise application demonstrating core framework fundamentals, component decoupling, externalized configuration, and custom bean scopes.

## Key Technical Features & Concepts
- **Spring Bean Management & Custom Scopes:** 
  - *Singleton Scope:* Shared application-wide gateway instance (`EmailGatewaySimulator`).
  - *Prototype Scope:* Fresh instance creation per request (`NotificationTracker`).
- **Constructor-Based Dependency Injection:** Strict decoupling across Controller, Service, Repository, and Component layers.
- **Externalized Configuration:** Type-safe property binding using `@ConfigurationProperties` mapped from `application.yml`.
- **Validation & REST Architecture:** Controller endpoints secured with Jakarta Bean Validation (`@Valid`) and DTO separation.
- **Testing Suite:** Integration tests verifying bean lifecycle and container scopes using JUnit 5 and Spring Boot Test.

## 🛠️ Tech Stack
- **Language:** Java 17
- **Framework:** Spring Boot 3.2.5
- **Build Tool:** Apache Maven
- **Testing Framework:** JUnit 5 / AssertJ
- **IDE:** Visual Studio Code

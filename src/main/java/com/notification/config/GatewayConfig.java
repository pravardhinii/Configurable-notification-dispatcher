package com.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class GatewayConfig {

    // Singleton Scope (Default): Shared application-wide instance
    @Bean
    @Scope("singleton")
    public EmailGatewaySimulator emailGatewaySimulator() {
        return new EmailGatewaySimulator("smtp.secure-gateway.com");
    }

    // Prototype Scope: Fresh instance created on every injection or request
    @Bean
    @Scope("prototype")
    public NotificationTracker notificationTracker() {
        return new NotificationTracker();
    }

    public static class EmailGatewaySimulator {
        private final String smtpServer;

        public EmailGatewaySimulator(String smtpServer) {
            this.smtpServer = smtpServer;
        }

        public void sendEmail(String recipient, String message) {
            System.out.println("[EmailGateway via " + smtpServer + "] Sending to " + recipient + ": " + message);
        }
    }

    public static class NotificationTracker {
        private final long instanceId = System.nanoTime();

        public long getInstanceId() {
            return instanceId;
        }
    }
}
package com.notification.repository;

import org.springframework.stereotype.Repository;

@Repository
public class NotificationRepository {

    public void saveDispatchRecord(String channel, String status) {
        System.out.println("[Database @Repository] Saved dispatch log -> Channel: " + channel + ", Status: " + status);
    }
}
package com.notification.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;

@ConfigurationProperties(prefix = "app.notification")
public class NotificationProperties {

    private List<String> enabledChannels;
    private int rateLimit;
    private String defaultSender;

    public List<String> getEnabledChannels() {
        return enabledChannels;
    }

    public void setEnabledChannels(List<String> enabledChannels) {
        this.enabledChannels = enabledChannels;
    }

    public int getRateLimit() {
        return rateLimit;
    }

    public void setRateLimit(int rateLimit) {
        this.rateLimit = rateLimit;
    }

    public String getDefaultSender() {
        return defaultSender;
    }

    public void setDefaultSender(String defaultSender) {
        this.defaultSender = defaultSender;
    }
}
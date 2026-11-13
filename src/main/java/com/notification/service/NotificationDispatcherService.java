package com.notification.service;

import com.notification.component.ChannelFormatter;
import com.notification.config.GatewayConfig;
import com.notification.config.NotificationProperties;
import com.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationDispatcherService {

    private final NotificationRepository notificationRepository;
    private final NotificationProperties notificationProperties;
    private final ChannelFormatter channelFormatter;
    private final GatewayConfig.EmailGatewaySimulator emailGatewaySimulator;

    // Constructor-based Dependency Injection
    public NotificationDispatcherService(NotificationRepository notificationRepository,
                                         NotificationProperties notificationProperties,
                                         ChannelFormatter channelFormatter,
                                         GatewayConfig.EmailGatewaySimulator emailGatewaySimulator) {
        this.notificationRepository = notificationRepository;
        this.notificationProperties = notificationProperties;
        this.channelFormatter = channelFormatter;
        this.emailGatewaySimulator = emailGatewaySimulator;
    }

    public void dispatch(String channel, String recipient, String message) {
        if (!notificationProperties.getEnabledChannels().contains(channel.toLowerCase())) {
            System.out.println("[Dispatcher] Channel '" + channel + "' is disabled in configuration!");
            return;
        }

        String formatted = channelFormatter.formatMessage(channel, message);
        
        if ("email".equalsIgnoreCase(channel)) {
            emailGatewaySimulator.sendEmail(recipient, formatted);
        } else {
            System.out.println("[Generic Dispatcher] Sending via " + channel + " with sender " + 
                               notificationProperties.getDefaultSender() + ": " + formatted);
        }

        notificationRepository.saveDispatchRecord(channel, "SUCCESS");
    }
}
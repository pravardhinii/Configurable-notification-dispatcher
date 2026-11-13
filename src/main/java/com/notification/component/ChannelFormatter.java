package com.notification.component;

import org.springframework.stereotype.Component;

@Component
public class ChannelFormatter {

    public String formatMessage(String channel, String rawMessage) {
        return "[" + channel.toUpperCase() + " FORMAT] " + rawMessage;
    }
}
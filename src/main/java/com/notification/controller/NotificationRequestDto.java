package com.notification.controller;

import jakarta.validation.constraints.NotBlank;

public class NotificationRequestDto {

    @NotBlank(message = "Channel cannot be blank")
    private String channel;

    @NotBlank(message = "Recipient cannot be blank")
    private String recipient;

    @NotBlank(message = "Message cannot be blank")
    private String message;

    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }
    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
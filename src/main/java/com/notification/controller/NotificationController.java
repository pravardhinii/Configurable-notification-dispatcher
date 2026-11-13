package com.notification.controller;

import com.notification.service.NotificationDispatcherService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationDispatcherService dispatcherService;

    public NotificationController(NotificationDispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@Valid @RequestBody NotificationRequestDto requestDto) {
        dispatcherService.dispatch(requestDto.getChannel(), requestDto.getRecipient(), requestDto.getMessage());
        return ResponseEntity.ok("Notification dispatched successfully for channel: " + requestDto.getChannel());
    }
}
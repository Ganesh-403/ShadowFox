package com.example.notification;

import com.example.common.NotificationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @PostMapping("/send")
    public String sendNotification(@RequestBody NotificationRequest notificationRequest) {
        return "Notification sent to " + notificationRequest.getUserEmail() + " with message: " + notificationRequest.getMessage();
    }
}

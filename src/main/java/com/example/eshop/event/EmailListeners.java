package com.example.eshop.event;

import com.example.eshop.data.dto.UserDTO;
import com.example.eshop.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmailListeners {

    private final EmailService emailService;

    @Async
    @EventListener
    public void onUserRegistered(UserRegisteredEvent event) {
        emailService.send("User registered: " + event.getUser().getFirstName());
    }
}

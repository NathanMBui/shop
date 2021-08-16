package com.example.eshop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailService {

    public void send(String content) {
        log.info("send email: {}", content);
    }
}

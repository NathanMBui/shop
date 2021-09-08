package com.example.eshop.event;

import com.example.eshop.data.dto.UserDTO;
import lombok.Data;

@Data
public class UserRegisteredEvent {
    private final UserDTO user;
}

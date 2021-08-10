package com.example.eshop.service;

import com.example.eshop.aspect.Loggable;
import com.example.eshop.data.dto.UserDTO;
import com.example.eshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Loggable
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Loggable
    public Optional<UserDTO> getUser(long id) {
        return UserDTO.ofNullable(userRepository.findById(id));
    }
}

package com.example.eshop.service;

import com.example.eshop.aspect.Loggable;
import com.example.eshop.data.dto.UserDTO;
import com.example.eshop.data.entity.User;
import com.example.eshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<UserDTO> searchUsers(String firstName, String lastName) {
        return userRepository.findByFirstNameOrLastName(firstName, lastName)
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public Page<UserDTO> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserDTO::new);
    }

    @Loggable
    public Optional<UserDTO> getUserById(long id) {
        return UserDTO.fromOptional(userRepository.findById(id));
    }

    public UserDTO createUser(UserDTO userDTO) {
        return new UserDTO(userRepository.save(userDTO.toEntity()));
    }
}

package com.example.eshop.service;

import com.example.eshop.aspect.Loggable;
import com.example.eshop.data.DataMapper;
import com.example.eshop.data.dto.UserDTO;
import com.example.eshop.data.entity.User;
import com.example.eshop.event.UserRegisteredEvent;
import com.example.eshop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService extends ServiceBase {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher publisher;
    private final UserRepository userRepository;

    @Loggable
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(mapper::userToUserDto)
                .collect(Collectors.toList());
    }

    public List<UserDTO> searchUsers(String firstName, String lastName) {
        return userRepository.findByFirstNameOrLastName(firstName, lastName)
                .stream()
                .map(mapper::userToUserDto)
                .collect(Collectors.toList());
    }

    public Page<UserDTO> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(mapper::userToUserDto);
    }

    @Loggable
    public Optional<UserDTO> getUserById(long id) {
        return Optional.of(mapper.userToUserDto(userRepository.findById(id).orElse(null)));
    }

    public UserDTO createUser(UserDTO userDTO) {
        UserDTO user = mapper.userToUserDto(userRepository.save(mapper.userDtoToUser(userDTO)));
        publisher.publishEvent(new UserRegisteredEvent(user));
        return user;
    }

    public Authentication signin(String username, String password) {
        System.out.println("authen: " + username + " " + password);
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println("authentication: " + authentication);
            return authentication;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Optional<UserDTO> signup(UserDTO userInfo) {
        if (userRepository.findByEmailOrMobile(userInfo.getEmail(), userInfo.getMobile()).isPresent()) {
            return Optional.empty();
        }
        User user = mapper.userDtoToUser(userInfo);
        user.setPasswordHash(passwordEncoder.encode(userInfo.getPasswordHash()));
        user = userRepository.save(user);
        return Optional.of(mapper.userToUserDto(user));
    }
}

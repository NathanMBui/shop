package com.example.eshop.controller;

import com.example.eshop.data.dto.UserDTO;
import com.example.eshop.repository.ProductRepository;
import com.example.eshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping
//    public List<UserDTO> getUsers() {
//        return userService.getUsers();
//    }

    @GetMapping("")
    Page<UserDTO> getUsersPaginate(Pageable pageable) {
        return userService.getUsers(pageable);
    }

    @GetMapping("/search")
    public List<UserDTO> searchUsers(@RequestParam(required = false) String firstName,
                                     @RequestParam(required = false) String lastName) {
        return userService.searchUsers(firstName, lastName);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
    }
}

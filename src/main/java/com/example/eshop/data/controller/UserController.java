package com.example.eshop.data.controller;

import com.example.eshop.data.entity.Product;
import com.example.eshop.data.entity.User;
import com.example.eshop.data.repository.ProductRepository;
import com.example.eshop.data.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}

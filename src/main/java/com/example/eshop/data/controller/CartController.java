package com.example.eshop.data.controller;

import com.example.eshop.data.entity.Cart;
import com.example.eshop.data.entity.User;
import com.example.eshop.data.repository.CartRepository;
import com.example.eshop.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("carts")
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @GetMapping
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }
}

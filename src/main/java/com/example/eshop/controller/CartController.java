package com.example.eshop.controller;

import com.example.eshop.data.entity.Cart;
import com.example.eshop.repository.CartRepository;
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

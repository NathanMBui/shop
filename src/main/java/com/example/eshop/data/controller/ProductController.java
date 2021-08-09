package com.example.eshop.data.controller;

import com.example.eshop.data.entity.Product;
import com.example.eshop.data.entity.User;
import com.example.eshop.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}

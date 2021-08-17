package com.example.eshop.controller;

import com.example.eshop.data.dto.ProductDTO;
import com.example.eshop.data.entity.Product;
import com.example.eshop.repository.ProductRepository;
import com.example.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public Page<ProductDTO> getProducts(Pageable pageable) {
        return productService.getProducts(pageable);
    }
}

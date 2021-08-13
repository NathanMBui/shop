package com.example.eshop.repository;

import com.example.eshop.data.entity.Product;
import com.example.eshop.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByUser(UserEntity user);
}

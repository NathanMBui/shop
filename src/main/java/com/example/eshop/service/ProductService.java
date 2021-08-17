package com.example.eshop.service;

import com.example.eshop.data.dto.ProductDTO;
import com.example.eshop.data.entity.Product;
import com.example.eshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService extends ServiceBase {

    private ProductRepository productRepository;

    public Page<ProductDTO> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(mapper::productToProductDto);
    }

    public Optional<ProductDTO> getProduct(long id) {
        return Optional.of(mapper.productToProductDto(productRepository.findById(id).orElse(null)));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public int updateQuantity(Product product, int amount) {
        product.setQuantity(product.getQuantity() + amount);
        product = productRepository.save(product);
        return product.getQuantity();
    }
}

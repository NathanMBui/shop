package com.example.eshop.data.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDTO {
    private long id;
    private long cartId;
    private long productId;
    private String sku;
    private BigDecimal price;
    private float discount;
    private long quantity;
    private boolean active;
    private String content;
}

package com.example.eshop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name = "cart_item", schema = "shop")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cart_id")
    Cart cart;

    private String sku;
    BigDecimal price;
    float discount;
    long quantity;
    boolean active;
    Date createdDate;
    Date updatedDate;
    String content;
}

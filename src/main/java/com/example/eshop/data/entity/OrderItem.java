package com.example.eshop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "order_item", schema = "shop")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    Order order;
    String content;
    String sku;
    BigInteger price;
    Float discount;
    Long quantity;
    Date createdDate;
    Date updatedDate;
}

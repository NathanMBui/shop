package com.example.eshop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product", schema = "shop")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    UserEntity user;
    String title;
    String metaTitle;
    String content;
    String slug;
    String summary;
    String type;
    String sku;
    BigDecimal price;
    float discount;
    int quantity;
    boolean visible;
    Date publishedDate;
    @CreatedDate
    Date createdDate;
    @LastModifiedDate
    Date updatedDate;
    Date startDate;
    Date endDate;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Category> categories;
}

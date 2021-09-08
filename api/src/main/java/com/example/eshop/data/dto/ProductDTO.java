package com.example.eshop.data.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductDTO {
    private long id;
    private long userId;
    private String title;
    private String metaTitle;
    private String content;
    private String slug;
    private String summary;
    private String type;
    private String sku;
    private BigDecimal price;
    private Float discount;
    private int quantity;
    private boolean visible;
    private Date publishedDate;
    private Date startDate;
    private Date endDate;
}

package com.example.eshop.data.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderDTO {
    private long id;
    private long userId;
    private long sessionId;
    private String token;
    private Integer status;
    private BigInteger subTotal;
    private BigInteger grandTotal;
    private BigInteger total;
    private Float itemDiscount;
    private Float discount;
    private Float tax;
    private Float shipping;
    private String promo;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String email;
    private String line1;
    private String line2;
    private String city;
    private String province;
    private String country;
    private String content;
}

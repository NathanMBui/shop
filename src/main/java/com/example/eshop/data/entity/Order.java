package com.example.eshop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "order", schema = "shop")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    UserEntity user;

    long sessionId;
    String token;

    Integer status;
    BigInteger subTotal;
    BigInteger grandTotal;
    BigInteger total;
    Float itemDiscount;
    Float discount;
    Float tax;
    Float shipping;
    String promo;
    String firstName;
    String middleName;
    String lastName;
    String mobile;
    String email;
    String line1;
    String line2;
    String city;
    String province;
    String country;
    String content;
    Date createdDate;
    Date updatedDate;
}

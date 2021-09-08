package com.example.eshop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "`order`", schema = "shop")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

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
    private Date createdDate;
    private Date updatedDate;
}

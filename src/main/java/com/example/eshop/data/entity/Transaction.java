package com.example.eshop.data.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "transaction", schema = "shop")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @OneToOne @JoinColumn(name = "user_id")
    UserEntity user;

    @OneToOne @JoinColumn(name = "order_id")
    Order order;

    String content;
    String code;
    Integer type;
    Integer mode;
    Integer status;
    Date createdDate;
    Date updatedDate;
}

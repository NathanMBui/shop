package com.example.eshop.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "transaction", schema = "shop")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne @JoinColumn(name = "user_id")
    private User user;

    @OneToOne @JoinColumn(name = "order_id")
    private Order order;

    private String content;
    private String code;
    private Integer type;
    private Integer mode;
    private Integer status;
    private Date createdDate;
    private Date updatedDate;
}

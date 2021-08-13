package com.example.eshop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cart", schema = "shop")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    UserEntity user;

    long sessionId;
    String content;
    String token;
    String status;
    String firstName;
    String middleName;
    String lastName;
    String mobile;
    String line1;
    String line2;
    String city;
    String province;
    String country;
    Date createdDate;
    Date updatedDate;
}

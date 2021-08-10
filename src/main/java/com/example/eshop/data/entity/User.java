package com.example.eshop.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(schema = "shop")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String email;
    private String passwordHash;
    @Column(name = "admin")
    private boolean isAdmin;
    @Column(name = "vendor")
    private boolean isVendor;
    private Date registeredDate;
    private Date lastLogin;
    private String intro;
    private String profile;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;
}

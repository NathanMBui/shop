package com.example.eshop.user.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "shop")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @CreatedDate
    private Date registeredDate;
    private Date lastLogin;
    private String intro;
    private String profile;
}

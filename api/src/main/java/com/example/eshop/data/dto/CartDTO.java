package com.example.eshop.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private long id;
    private long sessionId;
    private long userId;
    private String content;
    private String token;
    private String status;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String line1;
    private String line2;
    private String city;
    private String province;
    private String country;
}

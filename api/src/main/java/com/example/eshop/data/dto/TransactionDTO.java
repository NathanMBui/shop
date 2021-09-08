package com.example.eshop.data.dto;

import lombok.Data;
@Data
public class TransactionDTO {
    private long id;
    private long userId;
    private long orderId;
    private String content;
    private String code;
    private int type;
    private int mode;
    private int status;
}

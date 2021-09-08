package com.example.eshop.user.service;

import com.example.eshop.user.data.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBase {

    @Autowired
    protected DataMapper mapper;
}

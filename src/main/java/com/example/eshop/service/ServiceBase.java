package com.example.eshop.service;

import com.example.eshop.data.DataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceBase {

    @Autowired
    protected DataMapper mapper;
}

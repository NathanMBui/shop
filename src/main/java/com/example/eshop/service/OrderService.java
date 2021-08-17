package com.example.eshop.service;

import com.example.eshop.data.dto.OrderDTO;

import java.util.Optional;

public interface OrderService {
    Optional<OrderDTO> getOrder(long orderId);
}

package com.example.eshop.service;

import com.example.eshop.data.dto.OrderDTO;
import com.example.eshop.data.dto.TransactionDTO;
import com.example.eshop.data.dto.UserDTO;
import com.example.eshop.data.entity.Order;
import com.example.eshop.data.entity.Transaction;
import com.example.eshop.data.entity.User;
import com.example.eshop.repository.OrderRepository;
import com.example.eshop.repository.TransactionRepository;
import com.example.eshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService extends ServiceBase {

    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private TransactionRepository transactionRepository;
    private ProductService productService;

    @Transactional
    public TransactionDTO saveOrderTransaction(long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        User user = order.getUser();
        Transaction transaction = new Transaction();
        transaction.setOrder(order);
        transaction.setUser(user);
        
        transaction = transactionRepository.save(transaction);

        order.getOrderItems().forEach(orderItem -> {
            productService.updateQuantity(orderItem.getProduct(), orderItem.getQuantity());
        });
        return mapper.transactionToTransactionDto(transaction);
    }


}

package com.example.dartwebshop.dao;

import com.example.dartwebshop.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDAO {
    @Autowired
    private OrderRepository orderRepository;


    public void placeOrder(List<Order> order) {
        orderRepository.saveAll(order);
    }
}


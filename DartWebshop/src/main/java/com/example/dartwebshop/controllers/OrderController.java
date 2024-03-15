package com.example.dartwebshop.controllers;

import com.example.dartwebshop.dao.OrderDAO;
import com.example.dartwebshop.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderDAO orderDAO;

    @PostMapping("/place")
    public ResponseEntity<Map<String, String>> placeOrder(@RequestBody List<Order> orders) {
        orderDAO.placeOrder(orders);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Order ontvangen!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}

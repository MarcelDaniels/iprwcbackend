package com.example.dartwebshop.dao;

import com.example.dartwebshop.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
}

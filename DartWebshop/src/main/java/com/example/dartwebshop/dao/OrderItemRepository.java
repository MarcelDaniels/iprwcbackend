package com.example.dartwebshop.dao;

import com.example.dartwebshop.models.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository <OrderItem, Long>{
}

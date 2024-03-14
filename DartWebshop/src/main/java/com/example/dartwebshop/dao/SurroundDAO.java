package com.example.dartwebshop.dao;

import com.example.dartwebshop.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SurroundDAO {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> getAllSurrounds(){
        return productRepository.findByCategorieNaam("Dart Surrounds");
    }
}

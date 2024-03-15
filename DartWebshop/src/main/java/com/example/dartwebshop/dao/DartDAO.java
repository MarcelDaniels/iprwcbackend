package com.example.dartwebshop.dao;

import com.example.dartwebshop.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DartDAO {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> getAllDarts(){
        return productRepository.findByCategorieNaam("Dartpijlen");
    }
}

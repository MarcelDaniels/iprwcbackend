package com.example.dartwebshop.controllers;

import com.example.dartwebshop.dao.ProductDAO;
import com.example.dartwebshop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
    public class ProductController {

        @Autowired
        private ProductDAO productDAO;

        @PostMapping("/api/products")
        public ResponseEntity<Map<String, String>> addProduct(@RequestBody Product product) {
            productDAO.addProduct(product);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Product toegevoegd");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

        @DeleteMapping("/api/delete/{productId}")
        public void deleteProduct(@PathVariable Long productId) {
            productDAO.deleteProduct(productId);
        }
    }


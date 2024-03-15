package com.example.dartwebshop.dao;

import com.example.dartwebshop.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.categorie_id = (SELECT c.categorie_id FROM Categorie c WHERE c.naam = :categorieNaam)")
    List<Product> findByCategorieNaam(@Param("categorieNaam") String categorieNaam);
}

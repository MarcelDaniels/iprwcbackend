package com.example.dartwebshop.dao;

import com.example.dartwebshop.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u")
    List<User> findAllUsers();

    Optional<User> findByUsername(String username);
}

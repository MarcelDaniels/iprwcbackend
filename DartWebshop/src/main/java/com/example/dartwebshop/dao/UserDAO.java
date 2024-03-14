package com.example.dartwebshop.dao;
import com.example.dartwebshop.exception.ThrowNotFound;
import com.example.dartwebshop.models.Product;
import com.example.dartwebshop.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAO {
    @Autowired
    private UserRepository userRepository;
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAllUsers();
    }

    public void registerUser(String username, String wachtwoord) {
        User user = new User(username, wachtwoord, "customer");
        userRepository.save(user);
    }

    public User getByUsername(String name){
        Optional<User> optionalUser = this.userRepository.findByUsername(name);
        if(optionalUser.isEmpty()){
            throw new ThrowNotFound("User with name: " + name + "not found");
        }
        return optionalUser.get();
    }
}

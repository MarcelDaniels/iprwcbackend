package com.example.dartwebshop.controllers;
import com.example.dartwebshop.dao.UserDAO;
import com.example.dartwebshop.dao.UserRepository;
import com.example.dartwebshop.exception.ThrowNotFound;
import com.example.dartwebshop.models.ApiResponse;
import com.example.dartwebshop.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> custom(){return this.userDAO.getAllUsers();}


    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse get(@PathVariable String name){
        User user;
        String role;
        try {
            user = this.userDAO.getByUsername(name);
            role = user.getRole();
        } catch(ThrowNotFound exception) {
            return new ApiResponse(HttpStatus.NOT_FOUND, "No user with that id");
        }

        return new ApiResponse(HttpStatus.ACCEPTED, role);
    }
}

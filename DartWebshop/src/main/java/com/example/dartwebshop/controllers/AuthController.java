package com.example.dartwebshop.controllers;

import com.example.dartwebshop.dao.UserDAO;
import com.example.dartwebshop.models.User;
import com.example.dartwebshop.services.AuthService;
import com.example.dartwebshop.services.LoginRequest;
import com.example.dartwebshop.services.RegistrationRequest;
import com.example.dartwebshop.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserDAO userDAO;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;



    @PostMapping(value = "/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        System.out.println("registerUser()");
        String username = registrationRequest.getUsername();
        String hashedPassword = registrationRequest.getHashedPassword();
        userDAO.registerUser(username, hashedPassword);
        return ResponseEntity.ok("Registratie succesvol");
    }

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody LoginRequest loginRequest) throws JsonProcessingException {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        if (userService.authenticateUser(username, password)) {
            User user = userDAO.getByUsername(username);
            String JWT = authService.signin(loginRequest).getToken();
            Map<String, Object> response = new HashMap<>();
            response.put("user_id", user.getId());
            response.put("token", JWT);
            response.put("message", "Inloggen succesvol");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("message", "Onjuiste gebruikersnaam of wachtwoord"));
        }
    }
}

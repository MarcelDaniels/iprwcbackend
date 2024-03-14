package com.example.dartwebshop.services;

public class RegistrationRequest {
    private String username;
    private String wachtwoord;


    public RegistrationRequest(String username, String wachtwoord) {
        this.username = username;
        this.wachtwoord = wachtwoord;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return wachtwoord;
    }

    public void setHashedPassword(String hashedPassword) {
        this.wachtwoord = hashedPassword;
    }
}

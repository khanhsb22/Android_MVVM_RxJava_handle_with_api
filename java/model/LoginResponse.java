package com.example.demoapp.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

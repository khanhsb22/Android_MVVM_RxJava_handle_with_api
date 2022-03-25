package com.example.demoapp.model;

public class UserResponse {
    private String name;
    private String country;
    private String id;

    public UserResponse(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }
}

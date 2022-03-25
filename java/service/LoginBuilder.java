package com.example.demoapp.service;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginBuilder {
    private static final String URL = "https://60370fce5435040017721858.mockapi.io/api/v1/";
    private static LoginAPI loginAPI;
    public static LoginAPI builder() {
        loginAPI = new Retrofit.Builder().baseUrl(URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(LoginAPI.class);
        return loginAPI;
    }
}

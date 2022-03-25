package com.example.demoapp.service;

import com.example.demoapp.model.LoginResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LoginAPI {
    @GET("account")
    Observable<List<LoginResponse>> login();
}

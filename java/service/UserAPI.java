package com.example.demoapp.service;

import com.example.demoapp.model.UserResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserAPI {
    @GET("user")
    Observable<List<UserResponse>> getAllUser();

    @GET("user/{id}")
    Observable<UserResponse> getOneUser(@Path("id") String id);

    @POST("user")
    Observable<UserResponse> addOneUser(@Body UserResponse user);

    @PUT("user/{id}")
    Observable<UserResponse> updateOneUser(@Path("id") String id, @Body UserResponse user);

    @DELETE("user/{id}")
    Observable<UserResponse> deleteOneUser(@Path("id") String id);
}

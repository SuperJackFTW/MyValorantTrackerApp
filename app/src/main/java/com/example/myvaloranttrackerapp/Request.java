package com.example.myvaloranttrackerapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Request {
    @GET("/v1/agents/{uuid}")
    Call<Users> getUser(@Path("uuid")String uuid);

}

package com.example.myvaloranttrackerapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Request {
    @GET("/v1/agents/{uuid}")
        //Method to get userID
    Call<Users> getUser(@Path("uuid")String uuid);
}

package com.example.myvaloranttrackerapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RequestInterface {
    @GET("/v1/agents/{uuid}")
    Call<Users> getUser(@Path("uuid")String uuid);

}

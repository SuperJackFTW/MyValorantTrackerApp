package com.example.myvaloranttrackerapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Request {
    @GET("/v1/competitivetiers/{competitivetiersUuid}")
        //Method to get userID
    Call<CompetitiveTiers> getUser(@Path("competitivetiersUuid") String competitivetiersUuid);
}

package com.example.myvaloranttrackerapp;

import com.google.gson.annotations.SerializedName;

public class AllAgentsModel {
    @SerializedName("uuid")
    String uuid;

    public String getUuid() {
        return uuid;
    }
}

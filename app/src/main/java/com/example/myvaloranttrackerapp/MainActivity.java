package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.testData);
        myButton = findViewById(R.id.myButton);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://valorant-api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request requestingUser = retrofit.create(Request.class);
                requestingUser.getUser("564d8e28-c226-3180-6285-e48a390db8b1").enqueue(new Callback<CompetitiveTiers>() {
                    @Override
                    public void onResponse(Call<CompetitiveTiers> call, Response<CompetitiveTiers> response) {
                        myTextView.setText(response.body().tiers.tierName);
                    }

                    @Override
                    public void onFailure(Call<CompetitiveTiers> call, Throwable t) {
                        myTextView.setText(t.getMessage());
                    }
                });
            }
        });



    }
}
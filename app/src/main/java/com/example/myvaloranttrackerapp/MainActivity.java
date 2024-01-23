package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
                .baseUrl("https://valorant-api.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request requestingUser = retrofit.create(Request.class);
                requestingUser.getUser("e370fa57-4757-3604-3648-499e1f642d3f").enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        myTextView.setText(response.body().data.displayName);
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        myTextView.setText(t.getMessage());
                    }
                });
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                MainActivity.this.finish();
                startActivity(i);
            }
        });



    }
}
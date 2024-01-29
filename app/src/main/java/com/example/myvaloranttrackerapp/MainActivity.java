package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView myTextView,getMyTextView2;
    Button myButton;
    ImageView firstPageImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.testData);
        myButton = findViewById(R.id.myButton);
        firstPageImage = findViewById(R.id.firstPageImage);

        String[] myStringArray = getResources().getStringArray(R.array.agent_uuids);
        StringBuilder myStringBuilder = new StringBuilder();

        Random random = new Random();
        int randomNum = random.nextInt(myStringArray.length);

        myStringBuilder.append(myStringArray[randomNum]);

        Request requestRetrofit = MyRetrofit.getRetrofit().create(Request.class);
        Call<Users> call = requestRetrofit.getUser(String.valueOf(myStringBuilder));

        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                String img = response.body().data.getDisplayIcon();
                Picasso.get().load(img).into(firstPageImage);
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }

}
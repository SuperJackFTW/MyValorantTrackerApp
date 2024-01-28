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
        myStringBuilder.append(myStringArray[1]);

//        for (String value : myStringArray){
//            myStringBuilder.append(value).append("\n");
//        }
//        myTextView.setText(myStringBuilder.toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://valorant-api.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Request requestRetrofit = retrofit.create(Request.class);


        //Displays the Image on the main page (Not Done, Left for now)
        requestRetrofit.getUser("e370fa57-4757-3604-3648-499e1f642d3f").enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                String img = response.body().data.displayIcon;
                Picasso.get().load(img).into(firstPageImage);
            }
            @Override
            public void onFailure(Call<Users> call, Throwable t) {
            }
        });

        //Button to access the next page through getting a Uuid (Incomplete, the button rn only goes to next page)
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request requestingUser = retrofit.create(Request.class);
                requestingUser.getUser("e370fa57-4757-3604-3648-499e1f642d3f").enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        myTextView.setText(t.getMessage());
                    }
                });
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }

}
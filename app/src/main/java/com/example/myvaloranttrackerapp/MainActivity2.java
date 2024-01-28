package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    Button addDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addDataButton = findViewById(R.id.addDataButton);

        String[] myStringArray = getResources().getStringArray(R.array.agent_uuids);
        StringBuilder myStringBuilder = new StringBuilder();

        for(int i= 0; i<(myStringArray.length)-1; i++){
            myStringBuilder.append(myStringArray[i]);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://valorant-api.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Request requestRetrofit = retrofit.create(Request.class);

        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity2.this);

                for(int i = 0; i< myStringArray.length; i++){
                    requestRetrofit.getUser(myStringArray[i]).enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {
                            String name = response.body().data.displayName;
                            String description = response.body().data.description;
                            String uuid = response.body().data.uuid;
                            String display_icon = response.body().data.displayIcon;
                            String developer_name = response.body().data.developerName;
                            String full_portrait = response.body().data.fullPortrait;

                            myDB.addAgents(name, description, uuid, display_icon,developer_name,full_portrait);
                        }
                        @Override
                        public void onFailure(Call<Users> call, Throwable t) {
                        }
                    });
                }
            }
        });

    }


}
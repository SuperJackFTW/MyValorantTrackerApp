package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.ClipData;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.litepal.LitePal;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity{

    Button addDataButton;
    RecyclerView myRecyclerView;
    MyDatabaseHelper myDB;
    ArrayList<String> name, description, uuid, display_icon, developer_name, full_portrait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        LitePal.initialize(this);
//        SQLiteDatabase myDatabase = LitePal.getDatabase();

        addDataButton = findViewById(R.id.addDataButton);

        String[] myStringArray = getResources().getStringArray(R.array.agent_uuids);
        StringBuilder myStringBuilder = new StringBuilder();

        for(int i= 0; i<(myStringArray.length)-1; i++){
            myStringBuilder.append(myStringArray[i]);
        }

        ArrayList<UsersRecyclerView> agents = new ArrayList<UsersRecyclerView>();

        agents.add(new UsersRecyclerView());

        myRecyclerView = findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(new Agents_RecyclerViewAdapter(getApplicationContext(),agents));

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
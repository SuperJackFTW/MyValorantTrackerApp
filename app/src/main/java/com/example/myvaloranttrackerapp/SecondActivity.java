package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String[] myStringArray = getResources().getStringArray(R.array.agent_uuids);

        RecyclerView myRecyclerView = findViewById(R.id.myRecyclerView);
        List<Users.DataClass> users = new ArrayList<Users.DataClass>();

        //Loop to add agents into the recyclerview
        for(int i = 1; i < (myStringArray.length)+1; i++){
            DatabaseColumn databaseRow = LitePal.find(DatabaseColumn.class, i);
            String img = databaseRow.getDisplayIcon();
            String name = databaseRow.getDisplayName();
            users.add(new Users.DataClass(name,img));
        }

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(new Agents_RecyclerViewAdapter(getApplicationContext(),users));

    }
}
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

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button btnFragment1;
    Button btnFragment2;
    TextView myTextView;

    ArrayList<Users> UserModel= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setUpUserModel();

        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);

        Agents_RecyclerViewAdapter adapter = new Agents_RecyclerViewAdapter(this, UserModel);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpUserModel(){
        String[] agentUuids = getResources().getStringArray(R.array.agent_uuids);

        for(int i=0; i<agentUuids.length; i++){
            UserModel.add(new Users(agentUuids[i]));
        }
        myTextView.setText(String.valueOf(UserModel));
    }
}
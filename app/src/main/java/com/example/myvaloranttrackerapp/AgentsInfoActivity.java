package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgentsInfoActivity extends AppCompatActivity {

    private String intentValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents);

        //Find the ids of two buttons
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        //Get intent value from previous activity with "NAME"
        Intent incomingIntent = getIntent();
        intentValue = incomingIntent.getStringExtra("NAME");

        //Make first fragment
        replaceFragment(new FirstFragment());

        button1.setOnClickListener(v -> replaceFragment(new FirstFragment()));
        button2.setOnClickListener(v -> replaceFragment(new SecondFragment()));
    }

    public void replaceFragment(Fragment fragment){
        Bundle args = new Bundle();
        args.putString("name",intentValue);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.myFragmentContainer, fragment, null)
                .setReorderingAllowed(true)
                .commit();
    }
}
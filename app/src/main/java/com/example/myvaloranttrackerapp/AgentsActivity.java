package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import org.litepal.LitePal;

public class AgentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents);

        //Find the ids of two buttons
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        //Get intent value from previous activity with "NAME"
        Intent incomingIntent = getIntent();
        String intentValue = incomingIntent.getStringExtra("NAME");

        //Make first fragment
        FirstFragment firstFragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString("name",intentValue);
        firstFragment.setArguments(args);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.myFragmentContainer, firstFragment, null)
                .setReorderingAllowed(true)
                .commit();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment firstFragment = new FirstFragment();
                Bundle args = new Bundle();
                args.putString("name",intentValue);
                firstFragment.setArguments(args);

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.myFragmentContainer, firstFragment, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                Bundle args = new Bundle();
                args.putString("name",intentValue);
                secondFragment.setArguments(args);

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.myFragmentContainer, secondFragment, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });
    }
}
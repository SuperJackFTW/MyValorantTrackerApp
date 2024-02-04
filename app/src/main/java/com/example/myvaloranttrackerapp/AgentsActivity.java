package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.litepal.LitePal;

public class AgentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        FirstFragment firstFragment = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.)

        Intent incomingIntent = getIntent();
        String intentValue = incomingIntent.getStringExtra("NAME");

        DatabaseColumn getResults = LitePal.where("displayName = ?", intentValue).findFirst(DatabaseColumn.class);
        String name = getResults.getDisplayName().toString();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.myFragmentContainer, FirstFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.myFragmentContainer, SecondFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });
    }
}
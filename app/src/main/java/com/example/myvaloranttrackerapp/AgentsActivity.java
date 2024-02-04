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

        //Make first fragment
        FirstFragment firstFragment = new FirstFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.myFragmentContainer, firstFragment, "Fragment1Tag");

        //Get intent value from previous activity with "NAME"
        Intent incomingIntent = getIntent();
        String intentValue = incomingIntent.getStringExtra("NAME");

        //Searches through the database where according to "NAME" to get all the data values according to its column
        DatabaseColumn getResults = LitePal.where("displayName = ?", intentValue).findFirst(DatabaseColumn.class);

        //Get values from database
        String name = getResults.getDisplayName().toString();
        String icon = getResults.getDisplayIcon().toString();
        String developerName = getResults.getDeveloperName().toString();
        String description = getResults.getDescription().toString();
        String fullPortrait = getResults.getFullPortrait().toString();
        String uuid = getResults.getUuid().toString();

        Log.d("THIS IS MY NAME",name);

        FirstFragment test = (FirstFragment) getSupportFragmentManager().findFragmentByTag("Fragment1Tag");
        Log.d("MY TEST THING", String.valueOf(test));

        //FirstFragment anotherTest = (FirstFragment) getSupportFragmentManager().findFragmentById(getMyFragmentId);

        //firstFragment.updateTextView(String.valueOf(anotherTest));

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
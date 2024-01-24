package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button btnFragment1;
    Button btnFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        btnFragment1 = findViewById(R.id.btnFragment1);
//        btnFragment1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.FragmentContainerView, MyFragment.class, null)
//                        .setReorderingAllowed(true)
//                        .commit();
//            }
//        });
//
//        btnFragment2 = findViewById(R.id.btnFragment2);
//        btnFragment2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//
//                fragmentManager.beginTransaction()
//                        .replace(R.id.FragmentContainerView, MyFragment2.class, null)
//                        .setReorderingAllowed(true)
//                        .commit();
//            }
//        });
    }
}
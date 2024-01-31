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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String[] myStringArray = getResources().getStringArray(R.array.agent_uuids);
        StringBuilder myStringBuilder = new StringBuilder();

        for(int i= 0; i<(myStringArray.length)-1; i++){
            myStringBuilder.append(myStringArray[i]);
        }

        RecyclerView myRecyclerView = findViewById(R.id.myRecyclerView);
        List<Users.DataClass> users = new ArrayList<Users.DataClass>();

        Request requestRetrofit = MyRetrofit.getRetrofit().create(Request.class);

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
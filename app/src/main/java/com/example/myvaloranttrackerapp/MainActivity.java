package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView myTextView,getMyTextView2;
    Button myButton;
    Button randomButton;
    ImageView firstPageImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LitePal.initialize(this);
        SQLiteDatabase db = LitePal.getDatabase();

        myTextView = findViewById(R.id.testData);
        myButton = findViewById(R.id.myButton);
        firstPageImage = findViewById(R.id.firstPageImage);

        String[] myStringArray = getResources().getStringArray(R.array.agent_uuids);
        StringBuilder myStringBuilder = new StringBuilder();

        Random random = new Random();
        int randomNum = random.nextInt(myStringArray.length);
        myStringBuilder.append(myStringArray[randomNum]);

        Request requestRetrofit = MyRetrofit.getRetrofit().create(Request.class);
        Call<Users> getTheImage = requestRetrofit.getUser(String.valueOf(myStringBuilder));


        for(int i= 0; i < myStringArray.length; i++){
            Call<Users> call = requestRetrofit.getUser(String.valueOf(myStringArray[i]));
            call.enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, Response<Users> response) {
                    String uuid = response.body().data.getUuid();
                    String description = response.body().data.getDescription();
                    String name = response.body().data.getDisplayName();
                    String icon = response.body().data.getDisplayIcon();
                    String portrait = response.body().data.getFullPortrait();
                    String developer = response.body().data.getDeveloperName();

                    DatabaseColumn databaseColumn = new DatabaseColumn();
                    databaseColumn.setUuid(uuid);
                    databaseColumn.setDescription(description);
                    databaseColumn.setDisplayName(name);
                    databaseColumn.setDisplayIcon(icon);
                    databaseColumn.setFullPortrait(portrait);
                    databaseColumn.setDeveloperName(developer);
                    databaseColumn.save();
                }

                @Override
                public void onFailure(Call<Users> call, Throwable t) {

                }
            });
        }


        getTheImage.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> getTheImage, Response<Users> response) {
                String img = response.body().data.getDisplayIcon();
                Picasso.get().load(img).into(firstPageImage);
            }

            @Override
            public void onFailure(Call<Users> getTheImage, Throwable t) {

            }
        });

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }
}
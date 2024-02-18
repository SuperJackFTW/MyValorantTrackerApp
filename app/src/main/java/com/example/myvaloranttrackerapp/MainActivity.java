package com.example.myvaloranttrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.litepal.LitePal;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    Button myButton;
    ImageView firstPageImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize and create a Database
        LitePal.initialize(this);

        //Find the ids from the xml
        myTextView = findViewById(R.id.testData);
        myButton = findViewById(R.id.myButton);
        firstPageImage = findViewById(R.id.firstPageImage);

        //Retrieve all the uuids (hardcoded) into the strings.xml file
        String[] myStringArray = getResources().getStringArray(R.array.agent_uuids);
        StringBuilder myStringBuilder = new StringBuilder();

        //To obtain a random number to be generated at the main screen.
        Random random = new Random();
        int randomNum = random.nextInt(myStringArray.length);
        myStringBuilder.append(myStringArray[randomNum]);

        //Request for retrofit
        RequestInterface requestRetrofit = MyRetrofit.getRetrofit().create(RequestInterface.class);

        //Retrieve the image from online API if no values exist in database, otherwise, just takes the image from database
        boolean isMyTableEmpty = LitePal.count(DatabaseColumn.class) == 0;
        if(isMyTableEmpty == false){
            DatabaseColumn findImage = LitePal.find(DatabaseColumn.class,randomNum);
            String img = findImage.getDisplayIcon();
            Picasso.get().load(img).into(firstPageImage);
        }
        else
        {
            //Retrieve image from online API
            Call<Users> getTheImage = requestRetrofit.getUser(String.valueOf(myStringBuilder));
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
        }

        //A forloop to retrieve all the values from the API and store it into the database.
        for(int i= 0; i < myStringArray.length; i++){

            //Finds if a certain uuid exists already in the database
            DatabaseColumn existingRecord = LitePal.where("uuid = ?", myStringArray[i]).findFirst(DatabaseColumn.class);

            //If exists, it prints int he LogCat to notify us that it is there
            if(existingRecord != null){
                if((existingRecord.getUuid()).equals(myStringArray[i])){
                    Log.w("Value Exists", String.valueOf(existingRecord.getUuid()));
                }
            }
            else
            {
                //If doesn't exist, it requests for the data from the online API
                Call<Users> call = requestRetrofit.getUser(String.valueOf(myStringArray[i]));
                call.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        //Get All the needed values
                        String uuid = response.body().data.getUuid();
                        String description = response.body().data.getDescription();
                        String name = response.body().data.getDisplayName();
                        String icon = response.body().data.getDisplayIcon();
                        String portrait = response.body().data.getFullPortrait();
                        String developer = response.body().data.getDeveloperName();

                        //Adding them all into the database per row.
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

        }

        //Button to navigate to the next activity.
        myButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(i);
        });
    }
}
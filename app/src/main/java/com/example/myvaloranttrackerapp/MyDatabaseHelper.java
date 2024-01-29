package com.example.myvaloranttrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "AgentDatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "agents";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "agent_name";
    private static final String COLUMN_DESCRIPTION = "agent_description";
    private static final String COLUMN_UUID = "agent_uuid";
    private static final String COLUMN_DISPLAY_ICON = "agent_display_icon";
    private static final String COLUMN_DEVELOPER_NAME = "agent_developer";
    private static final String COLUMN_FULL_PORTRAIT = "agent_portrait";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_UUID + " TEXT, " +
                COLUMN_DISPLAY_ICON + " TEXT, " +
                COLUMN_DEVELOPER_NAME + " TEXT, " +
                COLUMN_FULL_PORTRAIT + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addAgents(String name, String description, String uuid, String display_icon, String developer_name, String full_portrait){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Adds a data column for each
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_DESCRIPTION, description);
        cv.put(COLUMN_UUID, uuid);
        cv.put(COLUMN_DISPLAY_ICON, display_icon);
        cv.put(COLUMN_DEVELOPER_NAME, developer_name);
        cv.put(COLUMN_FULL_PORTRAIT, full_portrait);

        //insert all of the columns into a database
        db.insert(TABLE_NAME, null, cv);
        db.close();

        //Checks if the database is successfully created or failed
//        if(result == -1){
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
//        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}

package com.example.easyScheduler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.sql.Date;
import java.sql.Time;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "EasyLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Message";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_MESSAGE = "message";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                " " + COLUMN_MESSAGE + " TEXT, " + COLUMN_PHONE + " INTEGER," +
                "  " + COLUMN_DATE + " DATE, " + COLUMN_TIME + " TIME);";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }



    //adding details to database
    void addDetails(int phone, String message, String date, String time){
        //writing data to database
        SQLiteDatabase db = this.getWritableDatabase();
        //all app data and paste to database
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PHONE, phone);
        cv.put(COLUMN_MESSAGE, message);
        cv.put(COLUMN_DATE, String.valueOf(date));
        cv.put(COLUMN_TIME, String.valueOf(time));
        //import table name, null and cv values as parameters, store in long result
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }


    //getting data into RecycleView by reading it from the table Message
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        //reading data in a database
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            //checking if database is not null and execute raw query, store query result inside cursor
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}

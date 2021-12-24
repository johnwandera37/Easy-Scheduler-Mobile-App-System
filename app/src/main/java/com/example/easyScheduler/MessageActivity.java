package com.example.easyScheduler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {
    private Toolbar topToolBar;
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    DatabaseHelper DB;
    ArrayList<String> message_id, message_number, message_message, date, time;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        recyclerView = findViewById(R.id.recyclerView);

        //working of Floating button
        add_button = findViewById(R.id.add_btn);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, AddMessageActivity.class);
                startActivity(intent);

            }
        });

        //setting topToolBar to ActionBar
        topToolBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topToolBar);
        //hiding default app title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getting custom title
        TextView mTitle = (TextView) topToolBar.findViewById(R.id.toolBarTitle);
        //Display icon in toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baseline_message_24);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


//for bottom navigation items to be appear clearly
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

        //for bottom menu items to open activities
        bottomNavigationView.setSelectedItemId(R.id.Message);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class ));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.Alarm:
                        startActivity(new Intent(getApplicationContext(),AlarmActivity.class ));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.Message:
                        return true;


                    case R.id.Call:
                        startActivity(new Intent(getApplicationContext(),CallActivity.class ));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.Link:
                        startActivity(new Intent(getApplicationContext(),LinkActivity.class ));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
        //ends here!


        //initializing object DB its context(displaying results to array in recyclerView)
        DB = new DatabaseHelper(MessageActivity.this);
        message_id = new ArrayList<>();
        message_number = new ArrayList<>();
        message_message = new ArrayList<>();
        date = new ArrayList<>();
        time = new ArrayList<>();

        storeDataInArray();//taking data in array from the method, create customAdapter class for recyclerView

        //initialize the CustomAdapter, passing its parameters(last)
        customAdapter = new CustomAdapter(MessageActivity.this,this, message_id, message_number, message_message, date, time);
        //taking custom adapter into recyclerView
        recyclerView.setAdapter(customAdapter);

    }

    //override method for activity to restart
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    //creating method to get readAllData from cursor in DataBaseHelper
    void storeDataInArray(){
        Cursor cursor = DB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else {
            while(cursor.moveToNext()){
                message_id.add(cursor.getString(0));
                message_number.add(cursor.getString(1));
                message_message.add(cursor.getString(2));
                date.add(cursor.getString(3));
                time.add(cursor.getString(4));
                //the number means moving from column o to 4
            }
        }
    }
}
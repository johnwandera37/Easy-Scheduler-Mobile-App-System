package com.example.easyScheduler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MessageActivity extends AppCompatActivity {
    private EditText editNumber;
    private EditText editMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);


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




        ActivityCompat.requestPermissions(MessageActivity.this,new String[]
                {Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        editNumber = findViewById(R.id.enterNumber);
        editMessage = findViewById(R.id.enterMessage);

    }
    public void sendSMS (View view){
        String message = editMessage.getText().toString();
        String number = editNumber.getText().toString();
        SmsManager mySmsManger = SmsManager.getDefault();
        mySmsManger.sendTextMessage(number, null, message,null,null);
        Toast.makeText(this,"Message Sent",Toast.LENGTH_SHORT).show();
    }
}
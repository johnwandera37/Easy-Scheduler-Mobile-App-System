package com.example.easyScheduler;

import static android.content.Intent.ACTION_CALL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CallActivity extends AppCompatActivity {
    private EditText editText;
    private Button buttonCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);


        //for bottom navigation items to be appear clearly

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

        //for bottom menu items to open activities
        bottomNavigationView.setSelectedItemId(R.id.Call);
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
                        startActivity(new Intent(getApplicationContext(), MessageActivity.class ));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.Call:
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



        //working of the Call
        ActivityCompat.requestPermissions(this, new String[]
                        {Manifest.permission.CALL_PHONE, Manifest.permission.READ_CALL_LOG},
                PackageManager.PERMISSION_GRANTED);
        editText = findViewById(R.id.enterCallNumber);
        buttonCall = findViewById(R.id.scheduleCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = editText.getText().toString();
                Intent callIntent = new Intent(ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);

            }
        });
    }
}
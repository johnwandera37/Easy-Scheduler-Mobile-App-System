package com.example.easyScheduler;

import static android.content.Intent.ACTION_CALL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CallActivity extends AppCompatActivity {
    private Toolbar topToolBar;
    private TextInputEditText editText;
    private Button buttonCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        //setting topToolBar to ActionBar
        topToolBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topToolBar);
        //hiding default app title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getting custom title
        TextView mTitle = (TextView) topToolBar.findViewById(R.id.toolBarTitle);
        //Display icon in toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baseline_call_24);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


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
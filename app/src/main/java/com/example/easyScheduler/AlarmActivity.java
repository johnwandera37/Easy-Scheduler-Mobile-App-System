package com.example.easyScheduler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

import java.time.Clock;

public class AlarmActivity extends AppCompatActivity {
    private TextInputEditText HourEditText;
    private TextInputEditText MinEditText;
    private Button SetAlarmBtn;
    private Toolbar topToolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        //setting topToolBar to ActionBar
        topToolBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topToolBar);
        //hiding default app title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getting custom title
        TextView mTitle = (TextView) topToolBar.findViewById(R.id.toolBarTitle);
        //Display icon in toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baseline_alarm_24);
        getSupportActionBar().setDisplayUseLogoEnabled(true);



//for bottom navigation items to be appear clearly

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

        //for bottom menu items to open activities
        bottomNavigationView.setSelectedItemId(R.id.Alarm);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class ));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.Alarm:
                        return true;


                    case R.id.Message:
                        startActivity(new Intent(getApplicationContext(), MessageActivity.class ));
                        overridePendingTransition(0,0);
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



        //working of the Alarm

        HourEditText = findViewById(R.id.hour_time);
        MinEditText = findViewById(R.id.min_time);
        SetAlarmBtn = findViewById(R.id.set_alarm);

        SetAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = Integer.parseInt(HourEditText.getText().toString());
                int min = Integer.parseInt(MinEditText.getText().toString());
                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_HOUR,hour);
                i.putExtra(AlarmClock.EXTRA_MINUTES,min);

                if(hour<=24 && min<=60){
                startActivity(i);
                }
            }
        });


    }
}
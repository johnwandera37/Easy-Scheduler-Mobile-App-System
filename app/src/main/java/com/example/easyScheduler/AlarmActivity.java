package com.example.easyScheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Clock;

public class AlarmActivity extends AppCompatActivity {
    private EditText HourEditText;
    private EditText MinEditText;
    private Button SetAlarmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
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
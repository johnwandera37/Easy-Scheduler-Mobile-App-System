package com.example.easyScheduler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class AddMessageActivity extends AppCompatActivity {
    TextInputEditText addNumber, addMessage;
    DatePickerDialog datePickerDialog;
    Button addButton, dateBtn, timeBtn, sendButton;
    int hour, minute;//for time picker

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_message);

        ActivityCompat.requestPermissions(AddMessageActivity.this,new String[]
                {Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        initDatePicker();

        sendButton = findViewById(R.id.sendBtn);
        addNumber = findViewById(R.id.enterNumber);
        addMessage = findViewById(R.id.enterMessage);
        addButton = findViewById(R.id.addDetails);
        dateBtn = findViewById(R.id.selectDate);
        timeBtn = findViewById(R.id.selectTime);

        //sending message
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = addNumber.getText().toString();
                String message = addMessage.getText().toString();
                SmsManager mySmsManger = SmsManager.getDefault();
                mySmsManger.sendTextMessage(number, null, message,null,null);
                Toast.makeText(AddMessageActivity.this,"Message Sent",Toast.LENGTH_SHORT).show();

            }
        });
        //sending message


        //onClick listener to access DatabaseHelper
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDB = new DatabaseHelper(AddMessageActivity.this);
                myDB.addDetails( Integer.parseInt(Objects.requireNonNull(addNumber.getText()).toString().trim()),
                        Objects.requireNonNull(addMessage.getText()).toString().trim(),
                        Objects.requireNonNull(dateBtn.getText()).toString().trim(), Objects.requireNonNull(timeBtn.getText()).toString().trim());

            }
        });
        //onClick listener to access DatabaseHelper


        //setting button to show today's date(DatePicker)
        dateBtn.setText(getTodaysDate());

        //onClicking date button
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();

            }
        });

        //fot time picker
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                        hour = selectedHour;
                        minute = selectedMinute;
                        timeBtn.setText(String.format(Locale.getDefault(),"%02d:%02d", hour, minute));

                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddMessageActivity.this, onTimeSetListener, hour, minute, true);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
                //fot time picker

            }
        });


    }



    //for Date Picker
    private String getTodaysDate() {
        //getting today's Date
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateBtn.setText(date);

            }
        };

        //getting today's Date
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_DEVICE_DEFAULT_DARK;
        datePickerDialog = new DatePickerDialog(this,style, dateSetListener, year, month, day);


    }

    private String makeDateString(int day, int month, int year) {
        
        return getMonthFormat(month) + " " + day + " " + year;

    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";
        //Default
        return "JAN";
    }
    //for Date Picker
}
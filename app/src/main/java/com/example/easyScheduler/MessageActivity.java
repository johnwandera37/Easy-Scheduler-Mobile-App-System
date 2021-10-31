package com.example.easyScheduler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {
    private EditText editNumber;
    private EditText editMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
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